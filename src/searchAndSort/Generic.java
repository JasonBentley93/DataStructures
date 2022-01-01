package searchAndSort;

import utility.Comparator;

import java.util.List;

public class Generic {


    /*************************************************************
     * Iterative Implementation of BinarySearch.
     *************************************************************/
    public static <T extends Comparable<T>> int binarySearch(List<T> data, T target) {
        int mid;
        int min = 0;
        int max = data.size() - 1;

        while (min <= max) {
            mid = (min + max) / 2;

            if (data.get(mid).compareTo(target) == 0)
                return mid;

            else if (data.get(mid).compareTo(target) < 0)
                min = mid + 1;

            else
                max = mid - 1;
        }
        return -1;
    }

    /*************************************************************
     * Recursive Implementation of QuickSort with Comparable.
     *************************************************************/
    private static <T extends Comparable<T>> int partition(List<T> data, int low, int high) {
        int mid = low + (high - low) / 2;
        T pivot = data.get(mid);
        boolean done = false;

        while (!done) {
            while (data.get(low).compareTo(pivot) < 0)
                ++low;

            while (pivot.compareTo(data.get(high)) < 0)
                --high;

            if (low >= high) {
                done = true;
            } else {
                swap(data, low, high);
                ++low;
                --high;
            }
        }

        return high;
    }

    public static <T extends Comparable<T>> void quickSort(List<T> data) {
        int n = data.size();
        quickSort(data, 0, n - 1);
    }

    private static <T extends Comparable<T>> void quickSort(List<T> data, int min, int max) {
        int mid;
        if (min < max) {

            mid = partition(data, min, max);
            quickSort(data, min, mid);
            quickSort(data, mid + 1, max);
        }
    }

    /*************************************************************
     * Recursive Implementation of QuickSort with Comparator.
     *************************************************************/
    private static <T> int partition(List<T> data, int low, int high, Comparator<T> comp) {

            int mid = low + (high - low) / 2;
            T pivot = data.get(mid);
            boolean done = false;

            while (!done) {
                while (comp.compare(data.get(low), pivot) < 0)
                    ++low;

                while (comp.compare(pivot, data.get(high)) < 0)
                    --high;

                if (low >= high) {
                    done = true;
                } else {
                    swap(data, low, high);
                    ++low;
                    --high;
                }
            }

            return high;

    }

    public static <T> void quickSort(List<T> data, Comparator<T> comp) {
        int n = data.size();
        quickSort(data, 0, n - 1,comp);
    }

    private static <T> void quickSort(List<T> data, int min, int max, Comparator<T> comp) {
        int mid;
        if (min < max) {

            mid = partition(data, min, max,comp);
            quickSort(data, min, mid,comp);
            quickSort(data, mid + 1, max,comp);
        }
    }

        /*************************************************************
         * Swaps through finding indexes.
         *************************************************************/
        public static <T> void swap (List < T > data,int a, int b){
            T temp = data.get(a);
            data.set(a, data.get(b));
            data.set(b, temp);
        }


}
