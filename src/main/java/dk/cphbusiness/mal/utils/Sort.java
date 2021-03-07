package dk.cphbusiness.mal.utils;

import java.util.Comparator;

public interface Sort<T> {
    void sort(T[] arr, Comparator<T> comparator);

    default void printArray(T[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
    };
}
