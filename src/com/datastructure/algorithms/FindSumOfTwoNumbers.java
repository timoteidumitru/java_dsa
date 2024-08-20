package com.datastructure.algorithms;

import java.util.*;

public class FindSumOfTwoNumbers {
    public static void main(String[] args) {
        findSumOfTwoNumbers();
    }

    public static void findSumOfTwoNumbers(){
        int[] nums = {2,3,4,5,6,7,9,12,13,14,15,17};
        int target = 32;
        int left = nums[0];
        int right = nums.length-1;

        System.out.println("Find " + target + " by adding 2 numbers in the following array: " + Arrays.toString(nums));
        for (int i=0;i<=nums.length-1;i++){
            for (int j=right;j>=left;j--){
                if (nums[i] + nums[j] == target && nums[i] < nums[j]){
                    System.out.println("Numbers found: " + nums[i] + " + " + nums[j] + " = " + (nums[i] + nums[j]));
                }
            }
        }
    }
}
