package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FleaMarket {

    public static int solve(int n, int S, int W, int[] space, int[] weight, int[] price)
    {

        return 0;
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
