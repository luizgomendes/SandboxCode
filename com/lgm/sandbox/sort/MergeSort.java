package com.lgm.sandbox.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> extends GenericSort<T> {
    public MergeSort(List<T> unsortedArray) {
        super(unsortedArray);
    }

    @Override
    public void sort() {
        sortedArray = mergeSort(unsortedArray);
    }

    private List<T> mergeSort(List<T> list) {
        if (list.size() < 2) {
            return list;
        }
        int mid = list.size()/2;
        return merge(
                mergeSort(list.subList(0, mid)),
                mergeSort(list.subList(mid, list.size())));
    }


    private List<T> merge(List<T> left, List<T> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<T> merged = new ArrayList<T>();

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        return merged;
    }

    public static void main(String[] args) {

        MergeSort<Integer> mergeSort = new MergeSort<Integer>(MergeSort.generateRandomIntList());
        mergeSort.printList(mergeSort.unsortedArray, "Unsorted");
        mergeSort.sort();
        mergeSort.printList(mergeSort.sortedArray, "Sorted");
    }
}
