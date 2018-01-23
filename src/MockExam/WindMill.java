package MockExam;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class WindMill {

    public static int solve(int n, int D, int[] d, int[] e) {

        int[] DP = new int[n + 1];
        int k = 0;

        for(int i = 1; i <= n; i++) {
            if(d[i] - d[1] < D) {
                k = 0;
            }
            else {
                while(d[i] - d[k + 1] >= D) {
                    k++;
                }
            }

            DP[i] = Math.max(DP[i - 1], DP[k] + e[i]);
        }

        return DP[n];
    }

    public static void read_and_solve(InputStream in, PrintStream out) {

        Scanner input = new Scanner(in);
        int testCases = input.nextInt();

        for(int i = 0; i < testCases; i++) {
            int n = input.nextInt();
            int D = input.nextInt();

            int[] d = new int[n + 1];
            int[] e = new int[n + 1];

            for(int j = 1; j <= n; j++) {
                d[j] = input.nextInt();
            }

            for(int j = 1; j <= n; j++) {
                e[j] = input.nextInt();
            }

            out.println(solve(n, D, d, e));
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
