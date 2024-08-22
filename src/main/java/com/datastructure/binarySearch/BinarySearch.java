package com.datastructure.binarySearch;
import java.util.ArrayList;

public class BinarySearch {
    public ArrayList<Integer> generateArr(){
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i=0;i<1000000;i++){
            arrList.add(i);
        }
        return arrList;
    }

    public void binarySearch(ArrayList<Integer> arr, int target){
        if (arr.size() < target){
            System.out.println("Out of bound value.");
            return;
        }
        int left = 0;
        int right = arr.size();
        int count = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr.get(mid) == target){
                System.out.println("~~~ Target found after " + count + " steps ~~~");
                return;
            }else if(arr.get(mid) < target){
                count++;
                left = mid + 1;
                System.out.println("Right half, step: " + count);
            } else {
                count++;
                right = mid - 1;
                System.out.println("Left half, step: " + count);
            }
        }
        System.out.println("Element has not been found!");
    }
}
