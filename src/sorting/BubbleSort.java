package sorting;

public class BubbleSort {

    public static void sort(int[] arr) {
        int size = arr.length;
        boolean swapped;

        do {
            swapped = false;

            for(int i = 0; i < size - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            size -= 1;
        } while(swapped);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
