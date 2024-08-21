package com.helloWorld.helloWorld.common.thread;

public class extendsTread extends Thread {

    public static void main(String[] args) {
        extendsTread t1 = new extendsTread();
        extendsTread t2 = new extendsTread();

        t1.setName("Thread 1");
        t2.setName("Thread 2");

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
