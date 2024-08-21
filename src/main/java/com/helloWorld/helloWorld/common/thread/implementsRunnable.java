package com.helloWorld.helloWorld.common.thread;

public class implementsRunnable implements Runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new implementsRunnable(), "Thread 1");
        Thread t2 = new Thread(new implementsRunnable(), "Thread 2");

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
