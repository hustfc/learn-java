package Concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Pair {
    private int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pair() {
        this(0, 0);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void incrementX() {
        x ++;
    }
    public void incrementY() {
        y ++;
    }
    public String toString() {
        return "x: " + x + "y: " + y;
    }

    //如果这个错误很重要，那么可以继承RuntimeException
    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            //在内部类中访问外部类的对象，内部类就是this
            super("Pair values not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if(x != y)
            throw new PairValuesNotEqualException();
    }
}

//在线程安全类里面保护Pair对象
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
    public synchronized Pair getPair() {
        //保证原始数据安全，得到一个备份
        return new Pair(p.getX(), p.getY());
    }
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ignore) {}
    }
    public abstract void increment();
}

//将所有的方法监视器化
class PairManager1 extends PairManager {
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

//使用临界区
class PairManager2 extends PairManager {
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManager pm;
    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }
    public void run () {
        while (true)
            pm.increment();
    }
    public String toString() {
        return "Pair: " + pm.getPair() + "checkCounter = " + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pm;
    public PairChecker(PairManager pm) {
        this.pm = pm;
    }
    public void run() {
        while(true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

//测试两种不同的方法：监视器法、临界区法
public class CriticalSection {
    static void testApproaches(PairManager1 pm1, PairManager2 pm2) {
        ExecutorService exec = Executors.newCachedThreadPool();


    }
}
