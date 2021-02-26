package dk.cphbusiness.mal.utils;

public interface Sort {
    void sort(String[] arr);

    default void printArray(String[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
    };
}
