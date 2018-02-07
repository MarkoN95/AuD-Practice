package misc;

public class Subarray {

    private static int[] copyFromToInclusive(int[] source, int from, int to) {
        int[] res = new int[to - from + 1];

        for(int i = from; i <= to; i++) {
            res[i - from] = source[i];
        }

        return res;
    }

    public static int subarraySum(int[] arr) {
        int[] DP = new int[arr.length];

        DP[0] = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            DP[i] = Math.max(arr[i], DP[i - 1] + arr[i]);
            max = Math.max(max, DP[i]);
        }

        return max;
    }

    public static int[] maxSubarray(int[] arr) {
        int[] DP = new int[arr.length];

        DP[0] = arr[0];
        int max = arr[0];

        int startI = 0;
        int endI = 0;

        for(int i = 1; i < arr.length; i++) {
            DP[i] = Math.max(arr[i], DP[i - 1] + arr[i]);

            if(arr[i] > DP[i - 1] + arr[i] && DP[i] > max) { startI = i; }
            if(DP[i] > max) { endI = i; }

            max = Math.max(max, DP[i]);
        }

        return copyFromToInclusive(arr, startI, endI);
    }
}
