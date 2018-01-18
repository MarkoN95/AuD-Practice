package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MountainTrip {

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if(lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p);
            quickSort(arr, p + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo - 1;
        int j = hi + 1;

        while(true) {
            while(arr[++i] < pivot) {}
            while(arr[--j] > pivot) {}

            if(i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // largest index >= elem
    private static int lowerIndex(int[] arr, int elem) {
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] >= elem) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    // smallest index <= elem
    private static int upperIndex(int[] arr, int elem) {
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] <= elem) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    private static int inRange(int[] arr, int start, int end) {
        return upperIndex(arr, end) - lowerIndex(arr, start) + 1;
    }

    public static int solve(int n, int[] mountain_cities, int[] sea_cities, int[] trip_beginning, int[] trip_end) {

        sort(mountain_cities);
        sort(sea_cities);

        int start, end, seaCities, mountainCities;
        int mostMountainCities = 0;
        int bestTrip = -1;

        for(int i = 0; i < trip_end.length; i++) {
            start = trip_beginning[i];
            end = trip_end[i];

            seaCities = inRange(sea_cities, start, end);

            if(seaCities == 0) {
                mountainCities = inRange(mountain_cities, start, end);

                if(mountainCities > mostMountainCities) {
                    mostMountainCities = mountainCities;
                    bestTrip = i + 1;
                }
            }
        }

        return bestTrip;
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
