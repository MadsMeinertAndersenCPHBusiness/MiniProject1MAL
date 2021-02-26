package dk.cphbusiness.mal.utils;

import java.util.Arrays;

public class MergeSortString implements Sort {
    @Override
    public void sort(String[] arr) {
        if(arr.length <= 1) return;
        int mid = arr.length / 2;

        String[] left = Arrays.copyOfRange(arr, 0,mid);
        String[] right = Arrays.copyOfRange(arr, mid , arr.length);
        sort(left);
        sort(right);

        merge(arr, left, right);
    }
    public void merge(String[] arr, String[] left, String[] right){
        int l = 0;
        int r = 0;
        int a = 0;
        while(l < left.length && r < right.length){
            if (left[l].toLowerCase().compareTo(right[r].toLowerCase()) <= 0) {
                arr[a++] = left[l++];
            }else arr[a++] = right[r++];
        }
        while (l < left.length){
            arr[a++] = left[l++];
        }
        while (r < right.length){
            arr[a++] = right[r++];
        }
    }
}
