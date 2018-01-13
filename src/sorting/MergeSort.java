package sorting;

public class MergeSort {

    public static void sort(int[] arr) {
        if(arr.length > 1) {
            int mid = (arr.length + 1) / 2;

            int[] left = copyFromTo(arr, 0, mid);
            int[] right = copyFromTo(arr, mid, arr.length);

            sort(left);
            sort(right);

            merge(arr, left, right);
        }
    }

    private static int[] copyFromTo(int[] arr, int from, int to) {
        int[] copy = new int[to - from];

        for(int i = from; i < to; i++) {
            copy[i - from] = arr[i];
        }

        return copy;
    }

    private static void merge(int[] merged, int[] left, int[] right) {
        int li = 0;
        int ri = 0;
        int mi = 0;

        while(li < left.length && ri < right.length) {
            if(left[li] <= right[ri]) {
                merged[mi++] = left[li++];
            }
            else {
                merged[mi++] = right[ri++];
            }
        }

        while(li < left.length) {
            merged[mi++] = left[li++];
        }

        while(ri < right.length) {
            merged[mi++] = right[ri++];
        }
    }
}
