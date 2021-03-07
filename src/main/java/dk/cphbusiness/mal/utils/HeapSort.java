package dk.cphbusiness.mal.utils;

import java.util.Comparator;

public class HeapSort implements Sort {

    private void heapify(Object[] arr, int n, int i, Comparator<Object> comparator)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && comparator.compare(arr[l], arr[largest]) > 0)
            largest = l;

        if (r < n && comparator.compare(arr[r], arr[largest]) > 0)
            largest = r;

        if (largest != i) {
            Object swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            heapify(arr, n, largest, comparator);
        }
    }

    @Override
    public void sort(Object[] arr, Comparator comparator) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, comparator);


        for (int i = n - 1; i > 0; i--) {
            Object temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, comparator);
        }
    }
}
