package com.lgm.sandbox;

import java.util.Random;

public class NumberTest {

    public static boolean isPrime(Integer num) {
        int i=2;
        while(i<num/2) {
            if(num%i == 0) {
                System.out.println(num + " can be divided by " + i);
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = new Random().nextInt(10000);
        System.out.println(NumberTest.isPrime(num)?num + " is prime":num + " is not prime");
    }

}
