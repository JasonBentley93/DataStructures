package searchAndSort;

import static searchAndSort.Iterative.swap;

public class Recursive {

    public static int binarySearchRec(int[] data, int target) {
        return binarySearch(data, target, 0, data.length-1);
    }

    private static int binarySearch(int[] data, int target, int min, int max) {
        if (min > max){
            return -1;
        }
        int mid = (min + max) / 2;
        if (data[mid] < target){
            return binarySearch(data, target, mid + 1, max);
        } else if(data[mid] > target){
            return binarySearch(data, target, min, mid -1);
        }
        return mid;
    }


    private static int[] makeFirstHalf(int[] data) {
        int low   = 0;
        int high  = data.length-1;
        int mid   =  low + (high - low)/2;
        int[] firstHalf = new int[mid+1];

        for (int i = 0; i < mid+1; i++) {
            firstHalf[i] = data[i];
        }
        return firstHalf;
    }

    private static int[] makeSecondHalf(int[] data) {
        int low   = 0;
        int high  = data.length-1;
        int mid   =  low + (high - low)/2;

        int[] secondHalf = new int[high - mid];

        for (int i = 0; i < high-mid; i++) {
            secondHalf[i] = data[mid+1+i];
        }
        return secondHalf;
    }

    private static void merge(int[] data, int[] left, int[] right) {
       int index       = 0;
       int leftIndex   = 0;
       int rightIndex  = 0;

       while(leftIndex < left.length && rightIndex < right.length){
           if (left[leftIndex] < right[rightIndex])
               data[index++] = left[leftIndex++];
           else
               data[index++] = right[rightIndex++];
       }
       while (leftIndex < left.length){
           data[index++] = left[leftIndex++];
       }
       while (rightIndex < right.length){
           data[index++] = right[rightIndex++];
       }
    }

    public static void mergeSort(int[] data) {
        if (data.length > 1){
            int[] left = makeFirstHalf(data);
            mergeSort(left);

            int[] right = makeSecondHalf(data);
            mergeSort(right);

            merge(data, left, right);

        }
    }

    private static int partition(int[] data, int low, int high) {
        int mid       = low + (high - low)/2;
        int pivot     = data[mid];
        boolean done  = false;

        while (!done){
            while ( data[low] < pivot)
                ++low;

            while (pivot < data[high])
                --high;

            if (low >= high) {
                done = true;
            }else{
                swap(data, low, high);
                ++low;
                --high;
            }
        }

        return high;
    }

    public static void quickSort(int[] data) {
        int n = data.length;
        quickSort(data, 0, n-1);
    }

    private static void quickSort(int[] data, int min, int max) {
        int mid;
        if (min<max){

            mid = partition(data, min, max);
            quickSort(data, min, mid);
            quickSort(data, mid + 1, max);
        }

    }

    public static void selectionSortRec(int[] data) {
        selectionSort(data, 0);
    }

    private static void selectionSort(int[] data, int start){
        if (start < data.length -1){
            int minIndex = start;

            for (int i = start +1; i <data.length; i++){
                if (data[i] < data[minIndex]){
                    minIndex = i;
                }
            }
            swap(data, start, minIndex);
            selectionSort(data, start + 1);
        }
    }
}


