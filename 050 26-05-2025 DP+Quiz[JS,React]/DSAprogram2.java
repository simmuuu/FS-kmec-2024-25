/*
JVS Infra Pvt Ltd purchased a flatland of size M*N, and it is divided 
into 1*1 cells. They mave marked some cells with red colors indicated 
with 1 and other cells with blue color indicated with 0.

They want build the walls in the form of rectangles by connecting four distinct 
red colored cells on the flatland that forms an axis-aligned rectangle.
And only the corners of the walls need to be red colored.

Your task is to help, JVS Infra to count the number of rectangular walls
can be built by connecting the red colored cells on the flatland.

Input Format:
-------------
Line-1: Two space separated integers, M and N
Next M lines: N space separated integers, either 0 or 1 only.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
1 0 1 0
1 1 1 1
0 1 1 1

Sample Output-1:
----------------
4

Explanation:
-----------
Given flatland is:
1 0 1 0
1 1 1 1
0 1 1 1
Number of rectngular walls are: 4
rectangle-1: by connecting 1's at (0, 0), (1, 0), (0, 2), (1, 2)
rectangle-2: by connecting 1's at (1, 1), (1, 2), (2, 1), (2, 2)
rectangle-3: by connecting 1's at (1, 1), (1, 3), (2, 1), (2, 3)
rectangle-4: by connecting 1's at (1, 2), (2, 2), (1, 3), (2, 3)


Sample Input-2:
---------------
4 5
1 0 1 0 1
0 0 0 1 0
0 1 1 0 1
1 0 1 0 0

Sample Output-2:
----------------
2
*/

import java.util.*;

public class DSAprogram2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] grid = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(sol(grid, R, C));
    }

    private static int sol(int[][] grid, int R, int C) {
        int res = 0;

        // O(m^2 * n^2) 
        for(int r1 = 0; r1 < R; r1++) {
            for(int c1 = 0; c1 < C; c1++) {
                if(grid[r1][c1] != 1) continue;

                for(int r2 = r1 + 1; r2 < R; r2++) {
                    for(int c2 = c1 + 1; c2 < C; c2++) {
                        if(grid[r2][c2] != 1) continue;

                        if(grid[r1][c2] == 1 && grid[r2][c1] == 1) {
                            res++;
                        }
                    }
                }
            }
        }
        
        return res;
    }
}