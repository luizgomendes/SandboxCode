package com.lgm.sandbox;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    public static void getFrequency(String str) {
        Map<String, Long> charValue = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("Counting " + str);
        charValue.keySet().forEach(k -> System.out.println("Character " + k + " appears " + charValue.get(k) + " times" ));
    }

    public static void main(String[] args) {
        String frequencyTest = "test12312";
        getFrequency(frequencyTest);

    }

}
 