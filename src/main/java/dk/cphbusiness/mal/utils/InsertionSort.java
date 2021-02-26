package dk.cphbusiness.mal.utils;

public class InsertionSort implements Sort {
    @Override
    public void sort(String[] text) {
        int length = text.length;
        for (int i = 1;  i < length; ++i){
            String key = text[i];
            int index = i - 1;
            //String prev = text[index];

            while (index >= 0 && key.compareTo(text[index]) < 0){
              //  text[i] = prev;
                text[index + 1] = text[index];

                index = index - 1;
            }
                text[index + 1] = key;
        }
    }
}
