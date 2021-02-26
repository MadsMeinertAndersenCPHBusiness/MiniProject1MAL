package dk.cphbusiness.mal.utils;

import java.io.PrintStream;

public class Stopwatch implements AutoCloseable {
  private final PrintStream out;
  private final long nanos = System.nanoTime();

  public Stopwatch(PrintStream out) { this.out = out; }
  public Stopwatch() { this(System.out); }

  public double step() {
    return (System.nanoTime() - nanos)/1_000_000.0;
  }

  @Override
  public void close() {
    out.printf("%5.6f\n", step());
  }

  public static void main(String... args) throws Exception {
    try (Stopwatch sw = new Stopwatch()) {
      Thread.sleep(1000);
      System.out.printf("%5.6f\n", sw.step());
      Thread.sleep(500);
    }

    String[] array = FileUtility.toStringArray("./data/Test.txt", "[^A-Za-z']+");
    Sort insertionSort = new InsertionSort();
 /*
    insertionSort.sort(array);
    insertionSort.printArray(array);

    int[] test = {1,2,3,5,1,3};
    MergeSort mergeSort = new MergeSort();
    mergeSort.sort(test);
    for (int i = 0; i < test.length; i++){
      System.out.println(test[i] + " ");
    }

    MergeSortString mergeSortString = new MergeSortString();
    mergeSortString.sort(array);
    insertionSort.printArray(array);
*/

    SelectionSort selectionSort = new SelectionSort();
    selectionSort.sort(array);
    insertionSort.printArray(array);
  }
}
