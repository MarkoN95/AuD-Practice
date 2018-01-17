package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MountainTrip {

    public static int solve(int n, int[] mountain_cities, int[] sea_cities, int[] trip_beginning, int[] trip_end) {

        return 0;
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        int ntestcases = scanner.nextInt();

        for(int testno=0; testno<ntestcases; testno++)
        {
            int n = scanner.nextInt();
            int M = scanner.nextInt();
            int S = scanner.nextInt();
            int T = scanner.nextInt();

            int[] mountain_cities = new int[M];
            for(int i=0; i<M; i++)
                mountain_cities[i] = scanner.nextInt();

            int[] sea_cities = new int[S];
            for(int i=0; i<S; i++)
                sea_cities[i] = scanner.nextInt();

            int[] trip_beginning = new int[T];
            for(int i=0; i<T; i++)
                trip_beginning[i] = scanner.nextInt();

            int[] trip_end = new int[T];
            for(int i=0; i<T; i++)
                trip_end[i] = scanner.nextInt();

            out.println(solve(n, mountain_cities, sea_cities, trip_beginning, trip_end));
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
