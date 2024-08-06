package com.datastructure.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {13,2,1,4,6,8,3,5,9,7,11,13,17};
        int size = array.length;
        int temp = 0;

        System.out.println("Array before sorting: " + Arrays.toString(array));
        bubbleSort(array, size, temp);
        System.out.println("Array after sorting: " + Arrays.toString(array));

    }
    public static void bubbleSort(int[] array, int size, int temp){
        for (int i=0;i<size;i++){
            for (int j=0;j<array.length-1;j++){
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

}
