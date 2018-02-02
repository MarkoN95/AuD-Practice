package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FrequencyAssignment {

    public static int prev(int iStar, int j, int[] BEST, int[] SBEST) {
        if(BEST[iStar] != j) {
            return BEST[iStar];
        }

        return SBEST[iStar];
    }

    public static int solve(int N, int m, int[][] v, int[][] h)
    {
        int[][] OPT = new int[N + 1][m + 1];

        int[] BEST = new int[N + 1];
        int[] SBEST = new int[N + 1];

        int prev1, prev2, prev3, tempBestI, tempBestV, tempSBestI, tempSBestV;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= m; j++) {

                if(i >= 3) {
                    prev1 = prev(i - 1, j, BEST, SBEST);
                    prev2 = prev(i - 2, j, BEST, SBEST);
                    prev3 = prev(i - 3, j, BEST, SBEST);

                    OPT[i][j] = Math.max(
                            v[j][i] + OPT[i - 1][prev1],
                            Math.max(
                                    v[j][i] + v[j][i - 1] + OPT[i - 2][prev2],
                                    v[j][i] + v[j][i - 1] + v[j][i - 2] + h[j][i - 2] + OPT[i - 3][prev3]
                            )
                    );
                }
                else if(i == 2) {
                    prev1 = prev(i - 1, j, BEST, SBEST);
                    prev2 = prev(i - 2, j, BEST, SBEST);

                    OPT[i][j] = Math.max(
                            v[j][i] + OPT[i - 1][prev1],
                            v[j][i] + v[j][i - 1] + OPT[i - 2][prev2]
                    );
                }
                else {
                    prev1 = prev(i - 1, j, BEST, SBEST);

                    OPT[i][j] = v[j][i] + OPT[i - 1][prev1];
                }
            }

            tempBestV = 0;
            tempBestI = 0;

            for(int k = 0; k <= m; k++) {
                if(OPT[i][k] > tempBestV) {
                    tempBestV = OPT[i][k];
                    tempBestI = k;
                }
            }

            BEST[i] = tempBestI;

            tempSBestV = 0;
            tempSBestI = 0;

            for(int k = 0; k <= m; k++) {
                if(OPT[i][k] > tempSBestV && k != BEST[i]) {
                    tempSBestV = OPT[i][k];
                    tempSBestI = k;
                }
            }

            SBEST[i] = tempSBestI;
        }


        return OPT[N][BEST[N]];
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
