package com.lgm.sandbox.concurrency.semaphore;

public class SemSharedResource {

    private static int value = 0;
    public static int getNextValue() {
        return value++;
    }

    public static boolean valuesDepleted() {
        return value >= 20;
    }

}
