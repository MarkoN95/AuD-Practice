package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Inversions {

    private static int[] copyFromTo(int[] arr, int from, int to) {
        int[] copy = new int[to - from];

        for(int i = from; i < to; i++) {
            copy[i - from] = arr[i];
        }

        return copy;
    }

    private static int mergeAndCount(int[] merged, int[] left, int[] right) {
        int li = 0;
        int ri = 0;
        int mi = 0;
        int inversions = 0;

        while(li < left.length && ri < right.length) {
            if(left[li] <= right[ri]) {
                merged[mi++] = left[li++];
            }
            else {
                merged[mi++] = right[ri++];
                inversions += left.length - li;
            }
        }

        while(li < left.length) {
            merged[mi++] = left[li++];
        }

        while(ri < right.length) {
            merged[mi++] = right[ri++];
        }

        return inversions;
    }

    private static int sortAndCountInversions(int[] A) {
        if(A.length > 1) {
            int mid = (A.length + 1) / 2;

            int[] left = copyFromTo(A, 0, mid);
            int[] right = copyFromTo(A, mid, A.length);

            return sortAndCountInversions(left) + sortAndCountInversions(right) + mergeAndCount(A, left, right);
        }

        return 0;
    }

    static int solve(int[] A) {
        return sortAndCountInversions(A);
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        int ntestcases = scanner.nextInt();

        for(int testno=0; testno<ntestcases; testno++)
        {
            int n = scanner.nextInt();
            int[] A = new int[n];

            for(int i=0; i<n; i++)
                A[i] = scanner.nextInt();

            out.println(solve(A));
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
