package pl.sdacademy.java.advanced.exercises.day3.task35_36;

import java.util.concurrent.TimeUnit;

public class Task35 {

    public static void main(String[] args) throws InterruptedException {
        //MyThread myThread = new MyThread(); tworzenie z zadanie 34
        Thread thread1 = new Thread(new MyNewThread("job-1"));
        Thread thread2 = new Thread(new MyNewThread("job-2"));
        //thread2.start();

        thread1.start();
        TimeUnit.SECONDS.sleep(20);
        thread1.interrupt();

    }
}
