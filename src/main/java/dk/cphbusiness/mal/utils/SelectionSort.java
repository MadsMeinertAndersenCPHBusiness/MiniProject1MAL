package dk.cphbusiness.mal.utils;

public class SelectionSort implements Sort{
    @Override
    public void sort(String[] arr) {
        String key;
        int index = 0;
        int min = 0;

        while (index < arr.length){
            for (int i = index; i < arr.length ; i++) {
                if (arr[min].toLowerCase().compareTo(arr[i] .toLowerCase()) >= 0){
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
