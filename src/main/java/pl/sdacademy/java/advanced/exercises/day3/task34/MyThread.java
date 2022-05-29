package pl.sdacademy.java.advanced.exercises.day3.task34;

import java.util.Random;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("Starting: " + threadName);
            int sleepingTime = new Random().nextInt(7000) + 2000;
            System.out.println("Random value: " + sleepingTime + " for " + threadName);
            System.out.println("Sleeping " + threadName);
            Thread.sleep(sleepingTime);
            System.out.println("Running again " + threadName);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
