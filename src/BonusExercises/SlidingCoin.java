package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import java.util.ArrayDeque;

public class SlidingCoin {

    static int n;
    static int[] outdegrees;
    static int[][] adjLists;

    public static char solve() {

        ArrayDeque<Integer> topologicalOrder = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        boolean[] visited = new boolean[n];
        boolean[] win = new boolean[n];

        stack.push(0);

        while(!stack.isEmpty()) {
            int currVertex = stack.peek();

            if(visited[currVertex]) {
                topologicalOrder.addFirst(stack.pop());
            }
            else {
                visited[currVertex] = true;

                for(int i = outdegrees[currVertex] - 1; i >= 0; i--) {
                    int successor = adjLists[currVertex][i];

                    if(!visited[successor]) {
                        stack.push(successor);
                    }
                }
            }
        }

        for(int i = topologicalOrder.size() - 1; i >= 0; i--) {
            int currVertex = topologicalOrder.removeLast();

            for(int j = 0; j < outdegrees[currVertex]; j++) {
                int successor = adjLists[currVertex][j];

                if(!win[successor]) {
                    win[currVertex] = true;
                }
            }
        }

        return win[0] ? 'A' : 'B';
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        int ntestcases = scanner.nextInt();

        for(int testno=0; testno<ntestcases; testno++)
        {
            n = scanner.nextInt();
            outdegrees = new int[n];
            adjLists = new int[n][];

            for(int i=0; i<n; i++)
            {
                outdegrees[i] = scanner.nextInt();
                adjLists[i] = new int[outdegrees[i]];
                for(int j=0; j<outdegrees[i]; j++)
                    adjLists[i][j] = scanner.nextInt();
            }

            out.println(solve());
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
