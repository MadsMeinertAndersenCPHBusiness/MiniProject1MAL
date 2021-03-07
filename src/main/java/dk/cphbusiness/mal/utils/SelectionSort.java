package dk.cphbusiness.mal.utils;

import java.util.Comparator;

public class SelectionSort implements Sort {

    @Override
    public void sort(Object[] arr, Comparator comparator) {
        Object key;
        int index = 0;
        int min = 0;

        while (index < arr.length) {
            for (int i = index; i < arr.length; i++) {
                if (comparator.compare(arr[min], arr[i]) >= 0){
                    min = i;
                }
            }

            key = arr[index];
            arr[index] = arr[min];
            arr[min] = key;
            index++;
            min = index;
        }
    }

}
