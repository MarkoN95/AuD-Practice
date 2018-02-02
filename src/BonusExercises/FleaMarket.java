package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FleaMarket {

    public static int solve(int n, int S, int W, int[] space, int[] weight, int[] price)
    {
        int[][][] DP = new int[n + 1][S + 1][W + 1];

        for(int s = 1; s <= S; s++) {
            for(int w = 0; w <= W; w++) {
                DP[0][s][w] = Integer.MIN_VALUE;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int s = 0; s <= S; s++) {
                for(int w = 0; w <= W; w++) {
                    if(weight[i] <= w) {
                        DP[i][s][w] = Math.max(
                                DP[i - 1][s][w],
                                DP[i - 1][Math.max(0, s - space[i])][w - weight[i]] + price[i]
                        );
                    }
                    else {
                        DP[i][s][w] = DP[i - 1][s][w];
                    }
                }
            }
        }

        return DP[n][S][W];
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);

        int ntestcases = scanner.nextInt();
        for(int t=0; t<ntestcases; t++)
        {
            int n = scanner.nextInt();
            int S = scanner.nextInt();
            int W = scanner.nextInt();

            int[] space = new int[n+1];
            int[] weight = new int[n+1];
            int[] price = new int[n+1];

            for(int i=1; i<=n; i++)
            {
                space[i] = scanner.nextInt();
                weight[i] = scanner.nextInt();
                price[i] = scanner.nextInt();
            }

            out.println(solve(n, S, W, space, weight, price));
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
