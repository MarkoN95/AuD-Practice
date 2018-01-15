package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SubmatrixSum {

    static int n;
    static int[][] M;
    static int[][] auxM;

    static void preprocess() {
        auxM = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                auxM[i][j] = auxM[i][j - 1] + M[i][j];
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                auxM[j][i] = auxM[j - 1][i] + auxM[j][i];
            }
        }
    }

    static int query(int a, int b, int c, int d) {
        return auxM[b][d] - auxM[b][c - 1] - auxM[a - 1][d] + auxM[a - 1][c - 1];
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        n = scanner.nextInt();

        M = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
                M[i][j]=scanner.nextInt();
        }

        preprocess();

        int m = scanner.nextInt();
        for(int i=0; i<m; i++)
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            out.println(query(a,b,c,d));
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
