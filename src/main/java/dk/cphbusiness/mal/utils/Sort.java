package dk.cphbusiness.mal.utils;

public interface Sort {
    void sort(String[] text);

    default void printArray(String[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
    };
}
