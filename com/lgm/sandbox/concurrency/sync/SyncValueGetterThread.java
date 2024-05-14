package com.lgm.sandbox.concurrency.sync;

import java.util.ArrayList;
import java.util.List;

public class SyncValueGetterThread extends Thread{
    String threadName;
    List<Integer> acquiredValueList;


    public SyncValueGetterThread(String threadName) {
        this.threadName = threadName;
        acquiredValueList = new ArrayList<>();
    }

    @Override
    public void run() {

        try {

            while(!SyncSharedResource.valuesDepleted()) {
                int acquiredNext = SyncSharedResource.getNextValue();
                acquiredValueList.add(acquiredNext);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(threadName + " acquired " + String.join(",",acquiredValueList.stream().map(Integer::toUnsignedString).toList()));
        }
    }
}
