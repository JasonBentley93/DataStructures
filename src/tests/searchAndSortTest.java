package tests;

import java.util.Arrays;

import static searchAndSort.Iterative.*;
import static searchAndSort.Recursive.*;


public class searchAndSortTest {

    public static void checkBinarySearch(int[] data){
        System.out.println();
        System.out.println();
        System.out.println(" ---- B I N A R Y    S E A R C H -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        System.out.println("location of 2: " + binarySearchIterative(data, 2));
        System.out.println("location of 7: " + binarySearchIterative(data, 7));
        System.out.println("location of 9: " + binarySearchIterative(data, 9));
        System.out.println();
    }

    public static void checkBubbleSort(int[] data) {
        System.out.println();
        System.out.println();
        System.out.println(" ---- B U B B L E   S O R T -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        bubbleSort(data);
        System.out.println(Arrays.toString(data));
        System.out.println();

    }

    public static void checkInsertionSort(int[] data) {
        System.out.println();
        System.out.println();
        System.out.println(" ---- I N S E R T I O N   S O R T -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        insertionSort(data);
        System.out.println(Arrays.toString(data));
        System.out.println();

    }

    public static void checkMergeSort(int[] data) {
        System.out.println();
        System.out.println();
        System.out.println(" ---- M E R G E    S O R T   R E C U R S I V E -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        mergeSort(data);
        System.out.println(Arrays.toString(data));
        System.out.println();
    }

    public static void checkQuickSort(int[] data) {
        System.out.println();
        System.out.println();
        System.out.println(" ---- Q U I C K    S O R T   R E C U R S I V E -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        quickSort(data);
        System.out.println(Arrays.toString(data));
        System.out.println();

    }

    public static void checkRecursiveBinarySearch(int[] data){
        System.out.println();
        System.out.println(" ---- R E C U R S I V E   B I N A R Y   S E A R C H -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        System.out.println("location of 2: " + binarySearchRec(data, 2));
        System.out.println("location of 7: " + binarySearchRec(data, 7));
        System.out.println("location of 9: " + binarySearchRec(data, 9));
        System.out.println();
    }

    public static void checkSelectionSort(int[] data){
        System.out.println();
        System.out.println();
        System.out.println(" ---- S E L E C T I O N    S O R T -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        selectionSort(data);
        System.out.println(Arrays.toString(data));
        System.out.println();
    }

    public static void checkSelectionSortRecursive(int[] data) {
        System.out.println();
        System.out.println();
        System.out.println(" ---- S E L E C T I O N    S O R T    R E C U R S I V E -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        selectionSortRec(data);
        System.out.println(Arrays.toString(data));
        System.out.println();
    }
    public static void checkContains(int[] data) {
        System.out.println();
        System.out.println(" ---- L I N E A R   S E A R C H   C O N T A I N S -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        System.out.println("contains 3: " + contains(data, 3));
        System.out.println("contains 7: " + contains(data, 7));
        System.out.println("contains 8: " + contains(data, 8));
        System.out.println();
    }

    public static void checkIndexOf(int[] data) {
        System.out.println();
        System.out.println(" ---- L I N E A R   S E A R C H   I N D E X O F -----");
        System.out.println();
        System.out.println(Arrays.toString(data));
        System.out.println("location of 3: " + indexOf(data, 3));
        System.out.println("location of 7: " + indexOf(data, 7));
        System.out.println("location of 8: " + indexOf(data, 8));
        System.out.println();
    }



    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" A L G O R I T H M S    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        intro();
        int[] data  = {2, 9, 4, 1, 7, 5, 3, 8, 6};
        int[] data1 = {2, 5, 7, 1, 4, 3, 6};
        int[] data2 = {1, 2, 4, 5, 6, 8, 9};
        int[] data3 = {2, 5, 11, 1, 9, 4, 16, 8, 13};

        System.out.println("***************************************************");
        System.out.println();
        System.out.println("   S E A R C H I N G    A L G O R I T I T H I M S");
        System.out.println();
        System.out.println("***************************************************");


        checkIndexOf(new int[] {2, 5, 7, 1, 4, 3, 6});
        checkContains(new int[] {2, 5, 7, 1, 4, 3, 6});
        checkBinarySearch(new int[] {1, 2, 4, 5, 6, 8, 9});
        checkRecursiveBinarySearch(new int[] {1, 2, 4, 5, 6, 8, 9});

        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("    S O R T I N G    A L G O R I T I T H I M S");
        System.out.println();
        System.out.println("***************************************************");

        checkBubbleSort(new int[] {2, 9, 4, 1, 7, 5, 3, 8, 6});
        checkInsertionSort(new int[] {2, 9, 4, 1, 7, 5, 3, 8, 6});
        checkSelectionSort(new int[] {2, 9, 4, 1, 7, 5, 3, 8, 6});
        checkSelectionSortRecursive(new int[] {2, 9, 4, 1, 7, 5, 3, 8, 6});

        checkMergeSort(new int[]{2, 5, 11, 1, 9, 4, 16, 8, 13});
        checkQuickSort(new int[] {2, 5, 11, 1, 9, 4, 16, 8, 13});

    }

    public static void print(int[] list) {

        for(int i = 0; i < list.length; i++) {
            System.out.print("[" + i + "]");
        }
        System.out.println();

        //This uses a for-each loop to print out list
        for(int item : list) {
            System.out.print(" " + item + " ");
        }
        System.out.println();
        System.out.println();
    }
}
