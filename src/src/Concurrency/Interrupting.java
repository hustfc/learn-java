package Concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlock implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;
    public IOBlocked(InputStream in) { this.in = in; }
    public void run() {
        try {
            System.out.println("Waiting to read()");
            in.read();
        } catch (IOException e) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from block I/O");
            }
            else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while(true) {   //从来不会释放锁
            Thread.yield();
        }
    }
    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();    //执行这个需要解锁
            }
        }.start();
    }
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        f.cancel(true);
        System.out.println("Interrupting: " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception{
        test(new SleepBlock());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
