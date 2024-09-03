package com.javaPlayground.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindSecondHighestNumber {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,7,3,8,4,12,11,7,2,9,6);

        List<Integer> highestNum = nums.stream().distinct().sorted(Comparator.reverseOrder()).toList();

        System.out.println(highestNum.get(1));

    }
}

