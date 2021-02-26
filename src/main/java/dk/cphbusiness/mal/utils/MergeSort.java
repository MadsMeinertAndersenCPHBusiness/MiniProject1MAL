package dk.cphbusiness.mal.utils;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr) {
        if(arr.length <= 1) return;
        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0,mid);
        int[] right = Arrays.copyOfRange(arr, mid ,arr.length);
        sort(left);
        sort(right);

        merge(arr, left, right);
    }

    public void merge(int[] arr, int[] left, int[] right){
        int l = 0;
        int r = 0;
        int a = 0;
        while(l < left.length && r < right.length){
            if (left[l] < right[r]){
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
