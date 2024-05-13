package com.lgm.sanbox.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GenericSort<T> {
    protected List<T> unsortedArray;
    protected List<T> sortedArray;



    public GenericSort(List<T> unsortedArray) {
        this.unsortedArray = unsortedArray;
    }

    public abstract void sort();

    public void printList(List<T> list, String message) {
        System.out.println((message == null ? "" : message + " - ") + String.join(",", list.stream().map(Object::toString).toList()));
    }

    public static List<Integer> generateRandomIntList() {
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }

        return list;
    }
    public List<T> getUnsortedArray() {
        return unsortedArray;
    }

    public List<T> getSortedArray() {
        return sortedArray;
    }
}
