package com.helloWorld.helloWorld.common.thread;

public class Deadlock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        Deadlock deadlockExample = new Deadlock();
        deadlockExample.execute();
    }

    private void execute() {
        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock 2!");
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock 1!");
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();
    }
}