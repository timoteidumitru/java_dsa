package com.javaPlayground.algorithms;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,1,6,2,4};
        findMissingNumber(nums);
    }

    public static void findMissingNumber(int[] nums){
        int foundElem = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[j] < nums[i] + 2) {
                    if (foundElem == nums.length){
                        foundElem = 0;
                    } else {
                        foundElem = nums[j] + 1;
                    }
                    break;
                }
            }
        }

        System.out.println(foundElem == 0
                ? "No consecutive element missing in the list"
                : "element " + foundElem + " is missing from the list");
    }
}
