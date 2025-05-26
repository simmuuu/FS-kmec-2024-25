/* 
Arjun wants to build some homes in a land of size R*C.
He wanted to construct homes in rectangular shape.
The place which is remained will be used for gradening.
Accordingly he has prepared the plan and given as
an 2d array plan[][], where 1 indicates home, and 0 indicates garden area.

A home is set of cells with value 1 in rectangular shape.
He wants to findout all the homes in the plan and store their co-ordinates in 
the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting
co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate 
(bottom right corner) of i-th home.

Your task is to help Arjun to find all the homes and return the coords[][] of 
all the homes from top left corner to bottom right corner.

NOTE: No two homes are adjacent to each other in 4 directions,
(left, right, top, bottom).

Input Format:
-------------
Line-1: Two integers R and C, size of the land.
Next R lines: C space separated integers, either 0 or 1
0- represents garden area land and 1- represents the home.

Output Format:
--------------
Print 2d array, the co-ordinates of all homes.


Sample Input-1:
---------------
2 3
1 0 0
0 1 1
 
Sample Output-1:
----------------
[0, 0, 0, 0][1, 1, 1, 2]


Sample Input-2:
---------------
4 4
1 1 0 1
0 0 0 0
1 1 0 1
1 1 0 1
 
Sample Output-2:
----------------
[0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]


*/

import java.util.*;

public class DSAprogram2 {
    static int R, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        int[][] land = new int[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                land[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    int[] coords = new int[]{i, j, 0, 0};
                    bt(land, visited, coords, i, j);
                    System.out.print(Arrays.toString(coords));
                }
            }
        }
    }

    private static void bt(int[][] land, boolean[][] visited, int[] coords, int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || visited[r][c] || land[r][c] == 0) return;

        coords[2] = Math.max(coords[2], r);
        coords[3] = Math.max(coords[3], c);

        visited[r][c] = true;
        bt(land, visited, coords, r + 1, c);
        bt(land, visited, coords, r, c + 1);
    }
}