package com.lgm.test.concurrency.sync;

import java.util.ArrayList;
import java.util.List;
public class SyncValueGetterRunner {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            SyncValueGetterThread thread = new SyncValueGetterThread("Thread"+i);
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
