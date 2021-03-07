package dk.cphbusiness.mal.utils;

import java.util.Comparator;

public class InsertionSort implements Sort {

    @Override
    public void sort(Object[] arr, Comparator comparator) {
        int length = arr.length;
        for (int i = 1;  i < length; ++i){
            Object key = arr[i];
            int index = i - 1;

            while (index >= 0 && comparator.compare(key, arr[index]) < 0)
            {
                arr[index + 1] = arr[index];

                index = index - 1;
            }
            arr[index + 1] = key;
        }
    }
}
