package com.lgm.sanbox;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraySorter {

    public static void main(String[] args) {

        Double[] array = {Math.random()*100,Math.random()*100,Math.random()*100, null};
        List<Double> unsortedArray = Arrays.asList(array);

        List<Double> nullsFirstNatural = unsortedArray.stream().sorted(Comparator.nullsFirst(Comparator.naturalOrder())).toList();
        System.out.println(String.join(",", nullsFirstNatural.stream().map(d-> String.format("%.1f", d)).toList()));

        List<Double> nullsLastInverted = unsortedArray.stream().sorted(Comparator.nullsLast(Comparator.reverseOrder())).toList();
        System.out.println(String.join(",", nullsLastInverted.stream().map(d-> String.format("%.1f", d)).toList()));


    }
}
