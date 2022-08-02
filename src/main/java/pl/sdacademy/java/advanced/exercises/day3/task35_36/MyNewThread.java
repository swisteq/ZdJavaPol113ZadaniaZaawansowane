package pl.sdacademy.java.advanced.exercises.day3.task35_36;

import java.util.Random;

public class MyNewThread implements Runnable{
    private final String threadName;

    public MyNewThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            //String threadName = Thread.currentThread().getName();
            System.out.println("Starting: " + threadName);
            int sleepingTime = new Random().nextInt(7000) + 2000;
            System.out.println("Random value: " + sleepingTime + " for " + threadName);
            while(!Thread.interrupted()) {
                System.out.println("Sleeping " + threadName);
                Thread.sleep(sleepingTime);
            }
            System.out.println("Running again " + threadName);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
