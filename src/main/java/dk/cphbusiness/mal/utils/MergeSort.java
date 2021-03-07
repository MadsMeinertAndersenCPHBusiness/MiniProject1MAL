package dk.cphbusiness.mal.utils;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort implements Sort {

    private void merge(Object[] arr, Object[] left, Object[] right, Comparator comparator){
        int l = 0;
        int r = 0;
        int a = 0;
        while(l < left.length && r < right.length){
            if (comparator.compare(left[l], right[r]) <= 0) {
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

    @Override
    public void sort(Object[] arr, Comparator comparator) {
        if(arr.length <= 1) return;
        int mid = arr.length / 2;

        Object[] left = Arrays.copyOfRange(arr, 0,mid);
        Object[] right = Arrays.copyOfRange(arr, mid , arr.length);
        sort(left, comparator);
        sort(right, comparator);

        merge(arr, left, right, comparator);
    }
}
