package com.javaPlayground.algorithms;

import java.util.Arrays;
import java.util.List;

public class PermuteNums {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,3);
        int n = input.size();

        permuteNums(input, 0, n-1);
    }

    private static void permuteNums(List<Integer> input, int l, int r) {
        if (l == r) {
            for (int i : input){
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = l; i<=r; i++){
                swapNums(input, l, i);

                permuteNums(input, l+1, r);

                swapNums(input, l, i);
            }
        }
    }

    private static void swapNums(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}
