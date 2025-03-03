package com.ll.dataStructure;

import java.util.Arrays;

public class BinarySearch {
    private int[] sortedArray;
    public BinarySearch(int[] array){
        Arrays.sort(array);
        sortedArray = array;
    }

    public int search(int target){
        int left = 0;
        int right = sortedArray.length -1;

        while(left<right){
            int mid = left + (right - left) / 2;
            if(sortedArray[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return sortedArray[left] == target ? left : -1;
    }
}
