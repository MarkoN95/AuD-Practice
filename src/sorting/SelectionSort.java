package sorting;

public class SelectionSort {

    public static void sort(int[] arr) {
        for(int i = arr.length - 1; i >= 1; i--) {
            int max = getMaxIdx(arr, 0, i);
            swap(arr, max, i);
        }
    }

    private static int getMaxIdx(int[] arr, int start, int end) {
        int max = start;

        for(int i = start + 1; i <= end; i++) {
            if(arr[i] > arr[max]) {
                max = i;
            }
        }

        return max;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i2];
        arr[i2] = arr[i1];
        arr[i1] = temp;
    }
}

