package sorting;

public class HeapSort {

    public static void sort(int[] arr) {
        heapify(arr);

        int size = arr.length;
        while(size > 1) {
            swap(arr, 0, size - 1);
            sift_down(arr, 0, --size);
        }
    }

    private static void heapify(int[] arr) {
        if(arr.length <= 1) {
            return;
        }

        int i = arr.length / 2  - 1;
        do {
            sift_down(arr, i--, arr.length);
        } while(i >= 0);
    }

    private static void sift_down(int[] arr, int i, int size) {
        int lChild = 2 * i + 1;
        int rChild = lChild + 1;

        while(lChild < size) {
            int largerChild = max(arr, lChild, rChild, size);

            if(arr[i] < arr[largerChild]) {
                swap(arr, i, largerChild);
                i = largerChild;
                lChild = 2 * i + 1;
                rChild = lChild + 1;
            }
            else {
                break;
            }
        }
    }

    private static int max(int[] arr, int lChild, int rChild, int size) {
        if(rChild >= size) {
            return lChild;
        }

        return arr[lChild] > arr[rChild] ? lChild : rChild;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

