package com.lgm.test.concurrency.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemValueGetterThread extends Thread{

    Semaphore semaphore;
    String threadName;
    List<Integer> acquiredValueList;


    public SemValueGetterThread(Semaphore semaphore, String threadName) {
        this.semaphore = semaphore;
        this.threadName = threadName;
        acquiredValueList = new ArrayList<>();
    }

    @Override
    public void run() {

        try {

            while(!SemSharedResource.valuesDepleted()) {
                System.out.println(threadName + " waiting for shared resource");
                semaphore.acquire();
                System.out.println(threadName + " gets permit");
                int acquiredNext = SemSharedResource.getNextValue();
                System.out.println(threadName + " gets " + acquiredNext);
                acquiredValueList.add(acquiredNext);
                System.out.println(threadName + " releases shared resource");
                semaphore.release();
            }
        } catch (InterruptedException e) {
            semaphore.release();
        } finally {
            System.out.println(threadName + " acquired " + String.join(",",acquiredValueList.stream().map(Integer::toUnsignedString).toList()));
        }
    }
}
