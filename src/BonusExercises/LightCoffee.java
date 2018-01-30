package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class LightCoffee {
    public static int solve(int C, int n, int[] coin_values, int[] coin_weights) {
        
        return 0;
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
