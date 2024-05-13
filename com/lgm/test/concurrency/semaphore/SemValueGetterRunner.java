package com.lgm.test.concurrency.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemValueGetterRunner {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            SemValueGetterThread thread = new SemValueGetterThread(semaphore,"Thread"+i);
            thread.start();
            threads.add(thread);
        }

        try {
            for (Thread thread: threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
