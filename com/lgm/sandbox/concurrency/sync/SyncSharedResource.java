package com.lgm.sandbox.concurrency.sync;

public class SyncSharedResource {

    private static int value = 0;
    public static synchronized int getNextValue() {
        return value++;
    }

    public static boolean valuesDepleted() {
        return value >= 20;
    }

}
