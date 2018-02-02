package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FrequencyAssignment {

    public static int solve(int N, int m, int[][] v, int[][] h)
    {
        return 0;
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        int ntestcases = scanner.nextInt();

        for(int testno=0; testno<ntestcases; testno++)
        {
            int N = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] v = new int[m+1][N+1];
            int[][] h = new int[m+1][N+1];

            for(int j=1; j<=m; j++)
            {
                for(int i=1; i<=N; i++)
                    v[j][i] = scanner.nextInt();

                for(int i=1; i<=N-2; i++)
                    h[j][i] = scanner.nextInt();
            }

            out.println(solve(N, m, v, h));
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
