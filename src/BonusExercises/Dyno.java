package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Dyno {
    public static int solve(final int L, final int D, final int C, final  int[] cacti) {

        
        return 0;
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

            System.out.println(solve(L, D, C, cacti));
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
