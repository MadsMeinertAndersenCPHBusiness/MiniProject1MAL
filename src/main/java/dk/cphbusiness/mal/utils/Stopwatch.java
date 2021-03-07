package dk.cphbusiness.mal.utils;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


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

    String[] array = FileUtility.toStringArray("./data/shakespeare-complete-works.txt", "[^A-Za-z']+");
    //String[] array = FileUtility.toStringArray("./data/Test.txt", "[^A-Za-z']+");
    Arrays.stream(array).map(s -> s.toLowerCase()).collect(Collectors.toList());
    String[] selectionSortArray = array.clone();
    String[] heapSortArray = array.clone();
    String[] insertionSortArray = array.clone();
    String[] mergeSortArray = array.clone();
    String[] trieSortArray = array.clone();

    Sort selectionSort = new SelectionSort();
    Sort heapSort = new HeapSort();
    Sort insertionSort = new InsertionSort();
    Sort mergeSort = new MergeSort();
    TrieSort trieSort = new TrieSort();

    System.out.println("------------------------------");
    System.out.println("USING SELECTION SORT...");
    try (Stopwatch sw = new Stopwatch()) {
      selectionSort.sort(selectionSortArray, Comparator.naturalOrder());
      System.out.printf("SELECTION SORT TOOK: " + "%5.2f\n", sw.step());
    }
    System.out.println("------------------------------");

    System.out.println("------------------------------");
    System.out.println("USING INSERTION SORT...");
    try (Stopwatch sw = new Stopwatch()) {
      insertionSort.sort(insertionSortArray, Comparator.naturalOrder());
      System.out.printf("INSERTION SORT TOOK: " + "%5.2f\n", sw.step());
    }
    System.out.println("------------------------------");


    System.out.println("------------------------------");
    System.out.println("USING HEAP SORT...");
    try (Stopwatch sw = new Stopwatch()) {
      heapSort.sort(heapSortArray, Comparator.naturalOrder());
      System.out.printf("HEAP SORT TOOK: " + "%5.2f\n", sw.step());
    }
    System.out.println("------------------------------");

    System.out.println("------------------------------");
    System.out.println("USING MERGE SORT...");
    try (Stopwatch sw = new Stopwatch()) {
      mergeSort.sort(mergeSortArray, Comparator.naturalOrder());
      System.out.printf("MERGE SORT TOOK: " + "%5.2f\n", sw.step());
    }
    System.out.println("------------------------------");


    System.out.println("------------------------------");
    System.out.println("USING TRIE SORT...");
    try (Stopwatch stopwatch = new Stopwatch()){
      trieSort.sort(trieSortArray);
      System.out.printf("TRIE SORT TOOK: " + "%5.2f\n", stopwatch.step());
    }
  }
}
