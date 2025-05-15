/*
Pranav has a puzzle board filled with square boxes in the form of a grid.
Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

Pranav wants to find out the number of empty spaces which are completely 
surrounded by the square boxes (left, right, top, bottom) in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of empty groups surrounded by
the boxes in the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the board.
Next M lines: contains N space-separated either 0 or 1.

Output Format:
--------------
Print an integer, the number of empty spaces in the puzzle board.


Sample Input-1:
---------------
6 7
1 1 1 1 0 0 1
1 0 0 0 1 1 0
1 0 0 0 1 1 0
0 1 1 1 0 1 0
1 1 1 0 0 1 1
1 1 1 1 1 1 1

Sample Output-1:
----------------
2

Explanation:
------------
The 2 empty groups are as follows:
1st group starts at cell(1,1), 2nd group starts at cell(3,4).
The groups which are starts at cell(0,4), cell(1,6) and cell(3,0)
are not valid empty groups, because they are not completely surrounded by boxes.


Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
1

Explanation:
------------
The only empty group starts at cell(1,1) is surrounded by boxes. 
*/

import java.util.*;

public class DSAprogram1 {
    static int R, C;

    private static int sol(int[][] inp) {
        int res = 0;

        // mark cells connected to border
        for(int i = 0; i < R; i++) {
            if(inp[i][0] == 0) dfs(inp, i, 0);
            if(inp[i][C - 1] == 0) dfs(inp, i, C - 1);
        }
        for(int i = 0; i < C; i++) {
            if(inp[0][i] == 0) dfs(inp, 0, i);
            if(inp[R - 1][i] == 0) dfs(inp, R - 1, i);
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(inp[i][j] == 0) {
                    dfs(inp, i, j);
                    res++;
                }
            }
        }

        return res;
    } 

    private static void dfs(int[][] inp, int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || inp[r][c] != 0) {
            return;
        }

        inp[r][c] = 1;

        dfs(inp, r - 1, c);
        dfs(inp, r + 1, c);
        dfs(inp, r, c + 1);
        dfs(inp, r, c - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        int[][] inp = new int[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                inp[i][j] = sc.nextInt();
            }
        }

        System.out.println(sol(inp));
    }
}