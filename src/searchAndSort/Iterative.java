package searchAndSort;

public class Iterative {

    public static int binarySearchIterative(int[] data, int target) {
        int mid;
        int min  = 0;
        int max = data.length - 1;

        while (min <= max) {
            mid = (min + max) / 2;

            if (data[mid] == target)
                return mid;
            else if (data[mid] < target)
                min = mid + 1;
            else
                max = mid - 1;

        }
        return -1;
    }

    public static  void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++){
            for (int j = 1; j < data.length - i; j++){
                if (data[j] < data[j-1]){
                    swap(data, j, j-1);
                }
            }
        }
    }

    public static boolean contains(int[] data, int target) {
        int i;

        for (i = 0; i < data.length; i++){
            if (data[i] == target){
                return true;
            }
        }
        return false;
    }

    public static int indexOf(int[] data, int target) {
        int i;

        for (i = 0; i < data.length; i++){
            if (data[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void insertionSort(int[] data) {
        int current;
        int j;

        for (int i = 1; i < data.length; i++) {
            current = data[i];
            for (j = i; j > 0 && current < data[j-1] ; j--) {
                data[j] = data[j-1];
            }
            data[j] = current;
        }
    }

    public static void selectionSort(int[] data) {
        int minIndex;

        for (int i=0; i<data.length - 1; i++){
            minIndex = i;
            for (int j = i+1; j<data.length; j++){
                if (data[j] < data[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                swap(data, minIndex, i);
            }
        }
    }

    public static void swap(int[] data, int a, int b) {
        int temp  = data[a];
        data[a]   = data[b];
        data[b]   = temp;
    }

}
