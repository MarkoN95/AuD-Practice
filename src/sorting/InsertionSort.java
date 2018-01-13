package sorting;

public class InsertionSort {

    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
