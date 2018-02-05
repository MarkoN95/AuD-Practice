package PracticeExams;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CellTowers {
    public static int solve(int n, int L, int R, int[] d, int[] c) {
        
        return 0;
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);

        // Read the number of cases and loop over the cases
        int case_no, cases = scanner.nextInt();
        for (case_no = 0; case_no < cases; case_no++) {

            // Read the road length, tower range, number of locations
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            int n = scanner.nextInt();
            int i;

            // Array of tower locations on the road, sorted
            int[] d = new int[n];
            for (i = 0; i < n; i++) {
                d[i] = scanner.nextInt();
            }

            // Array of tower location costs
            int[] c = new int[n];
            for (i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }

            out.println(solve(n, L, R, d, c));
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
