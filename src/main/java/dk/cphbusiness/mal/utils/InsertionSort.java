package dk.cphbusiness.mal.utils;

public class InsertionSort implements Sort {
    @Override
    public void sort(String[] arr) {
        int length = arr.length;
        for (int i = 1;  i < length; ++i){
            String key = arr[i];
            int index = i - 1;
            //String prev = text[index];

            while (index >= 0 && key.compareTo(arr[index]) < 0){
              //  text[i] = prev;
                arr[index + 1] = arr[index];

                index = index - 1;
            }
                arr[index + 1] = key;
        }
    }
}
