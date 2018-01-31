package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class LightCoffee {
    public static int solve(int C, int n, int[] coin_values, int[] coin_weights) {
        int[][] DP_even = new int[n + 1][C + 1];
        int[][] DP_odd = new int[n + 1][C + 1];

        for(int i = 1; i <= n; i++) {
            int v_i = coin_values[i - 1];
            int w_i = coin_weights[i - 1];

            for(int j = 0; j <= C; j++) {
                int even_max = DP_even[i - 1][j];
                int odd_max = DP_odd[i - 1][j];

                if(v_i == j) {
                    odd_max = Math.max(odd_max, w_i);
                }
                else if(v_i < j) {
                    int even_cp = DP_even[i - 1][j - v_i];
                    int odd_cp = DP_odd[i - 1][j - v_i];

                    if(even_cp > 0) {
                        odd_max = Math.max(odd_max, even_cp + w_i);
                    }

                    if(odd_cp > 0) {
                        even_max = Math.max(even_max, odd_cp + w_i);
                    }
                }

                DP_even[i][j] = even_max;
                DP_odd[i][j] = odd_max;
            }
        }

        return DP_even[n][C];
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        int ntestcases = scanner.nextInt();

        for(int testno=0; testno<ntestcases; testno++)
        {
            int C = scanner.nextInt();

            int n = scanner.nextInt();
            int[] coin_values = new int[n];
            int[] coin_weights = new int[n];

            for(int i=0; i<n; i++)
                coin_values[i] = scanner.nextInt();

            for(int i=0; i<n; i++)
                coin_weights[i] = scanner.nextInt();

            out.println(solve(C, n, coin_values, coin_weights));
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
