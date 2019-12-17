package multi_threading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MultiThreads {

    static volatile int int1 = 1;

    public static void main(String[] args) {

        //create instances
        Thread myThread1 = new MyThread("myThread1");
        Thread myThread2 = new MyThread("myThread2");

        Runnable runnable1 = new RThread("runnable1");
        Runnable runnable2 = new RThread("runnable2");

        Callable callable1 = new CThread("callable1");
        Callable callable2 = new CThread("callable2");


        //run
        myThread1.start();
        myThread2.start();

        new Thread(runnable1).start();
        new Thread(runnable2).start();


        FutureTask<String> task1 = new FutureTask<String>(callable1);
        FutureTask<String> task2 = new FutureTask<String>(callable2);
        //new Thread(task1).start();
        //new Thread(task2).start();
        task1.run();
        task2.run();
        try {
            String result1 = task1.get();
            System.out.println(result1);

            String result2 = task2.get();
            System.out.println(result2);
        } catch (Exception e) {

        }


        //
        Integer i = 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(int1++);
            }
        }).start();
    }
}

class MyThread extends Thread {

    public String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " - " + this.name);
    }
}

class RThread implements Runnable {

    public String name;

    public RThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " - " + Thread.currentThread().getName());
    }
}

class CThread implements Callable {

    public String name;

    public CThread(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("calling " + name);
        return name;
    }
}
