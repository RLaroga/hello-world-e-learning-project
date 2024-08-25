package com.helloWorld.helloWorld.common.concurrency;

import java.util.concurrent.*;

public class Task implements Runnable {
    public static void main(String[] args) {
        System.out.println(execute());
    }

    private static boolean execute() {
        ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();

        Future<String> future = executorService.schedule(() -> {
            System.out.println("Hello");
            return "Success";
        }, 5, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture = executorService.schedule(() -> {
            System.out.println("World");
        }, 1, TimeUnit.SECONDS);

        executorService.shutdown();
        return false;
    }

    @Override
    public void run() {
        System.out.println("Task Implements Runnable class");
    }
}
