package multi_threading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class WaitNotifyTests {

    static volatile Integer a = 1;
    static volatile Integer b = 2;

    public static void main(String[] args) {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    synchronized (a) {
                        System.out.println("Thread 1 got lock of a");

                        synchronized (b) {

                            System.out.println("Thread 1 got lock of b");

                            System.out.println("Thread 1 release lock of a");
                            a.wait();

                            System.out.println("Thread 1 release lock of b");
                            b.wait();
                        }
                    }
                } catch (Exception e) {

                }
            }
        });

        thread1.start();

        // test join
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 starts");
        });

        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread ends");

        Thread.interrupted();
        NThread nThread = new NThread("");
        NThread.interrupted();
    }
}

class NThread extends Thread {

    public String name;

    public NThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " - " + this.name);
    }
}
