package com.datastructure.binarySearch;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int target = 786543;
        ArrayList<Integer> array = binarySearch.generateArr();

        binarySearch.binarySearch(array, target);

    }
}
