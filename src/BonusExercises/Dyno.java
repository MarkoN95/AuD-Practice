package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Dyno {

    private static int indexOf(int[] arr, int elem) {
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] > elem) {
                hi = mid - 1;
            }
            else if(arr[mid] < elem) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }

    private static boolean has(int[] arr, int elem) {
        return indexOf(arr, elem) != - 1;
    }

    public static int solve(final int L, final int D, final int C, final  int[] cacti) {
        int[] DP = new int[L];

        for(int i = 1; i < L; i++) {
            if((DP[i - 1] == i - 1 || (i >= D && DP[i - D] == i - D)) && !has(cacti, i)) {
                DP[i] = i;
            }
            else {
                DP[i] = DP[i - 1];
            }
        }

        return DP[L - 1];
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        int ntestcases = scanner.nextInt();

        for(int testno=0; testno<ntestcases; testno++)
        {
            int L = scanner.nextInt();
            int D = scanner.nextInt();
            int C = scanner.nextInt();

            int[] cacti = new int[C];
            for(int j=0; j<C; j++)
                cacti[j] = scanner.nextInt();

            out.println(solve(L, D, C, cacti));
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
