/*
Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally 
with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5
*/

import java.util.*;

public class DSAprogram2 {
    static int R, C;

    private static int sol(int[][] m) {
        int max = 0;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(m[i][j] == 1) {
                    max = Math.max(max, dfs(m, i, j));
                }
            }
        }

        return max;
    }

    private static int dfs(int[][] m, int r, int c) {
        if(Math.min(r, c) < 0 || r == R || c == C ||
            m[r][c] == 0) return 0;

        int count = 1;
        m[r][c] = 0;

        count += dfs(m, r + 1, c);
        count += dfs(m, r - 1, c);
        count += dfs(m, r, c + 1);
        count += dfs(m, r, c - 1);
        count += dfs(m, r + 1, c + 1);
        count += dfs(m, r + 1, c - 1);
        count += dfs(m, r - 1, c + 1);
        count += dfs(m, r - 1, c - 1);

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        int[][] m = new int[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        System.out.println(sol(m));
    }
}