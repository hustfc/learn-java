package Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Count {
    private int count = 0;
    private Random rand = new Random(47);
    //如果移除同步器测试
    public synchronized int increment() {
        int temp = count;
        //有一半概率退出控制权
        if(rand.nextBoolean())
            Thread.yield();
        return (count = ++ temp);
    }
    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number;  //当前经过的人数
    //在读取的时候不需要同步器
    private final int id;
    private static volatile boolean canceled = false;

    //volatile定义的变量是原子操作
    public static void cancel(){ canceled = true; }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public void run() {
        System.out.println(this + " count: " + count);
        while(!canceled) {
            synchronized(this) {
                ++ number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() { return number; }

    public String toString() {
        return "Entrance" + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for(Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i ++) {
            exec.execute(new Entrance(i));
        }
        //执行一段时间，然后收集数据
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Some task were not terminated!");
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
