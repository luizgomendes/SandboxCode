package com.lgm.sanbox.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends GenericSort<T>  {

    public QuickSort(List<T> unsortedArray) {
        super(unsortedArray);
    }

    private void quickSort (List<T> array, int lowIndex, int highIndex) {
        if(lowIndex < highIndex) {
            int pivotIndex = partition(array, lowIndex, highIndex);
            quickSort(array, lowIndex, pivotIndex-1);
            quickSort(array,pivotIndex+1, highIndex);
        }
    }

    private int partition(List<T> array, int lowIndex, int highIndex) {

        T pivot = array.get(highIndex);
        int i = lowIndex-1;
        for (int j = lowIndex; j < highIndex; j++) {
            if(array.get(j).compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, highIndex);
        return (i + 1);
    }

    private void swap(List<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j,temp);

    }

    @Override
    public void sort() {
        sortedArray = new ArrayList<>();
        sortedArray.addAll(unsortedArray);
        quickSort(sortedArray, 0, sortedArray.size()-1);

    }

    public static void main(String[] args) {
        QuickSort<Integer> quickSort = new QuickSort<Integer>(QuickSort.generateRandomIntList());
        quickSort.printList(quickSort.getUnsortedArray(), "Unsorted");
        quickSort.sort();
        quickSort.printList(quickSort.getSortedArray(), "Sorted");
    }
}


