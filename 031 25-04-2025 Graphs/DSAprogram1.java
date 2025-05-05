import java.util.*;

/*
Pranav has a puzzle board filled with square boxes in the form of a grid. Some 
cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

The puzzle board has some patterns formed with boxes in it, 
the patterns may be repeated. The patterns are formed with boxes (1's) only, 
that are connected horizontally and vertically but not diagonally.

Pranav wants to find out the number of unique patterns in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of unique patterns in 
the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers [0, 1].

Output Format:
--------------
Print an integer, the number of unique patterns in the puzzle board.


Sample Input-1:
---------------
5 5
0 1 0 1 1
1 1 1 0 1
0 1 0 1 0
1 0 1 1 1
1 1 0 1 0

Sample Output-1:
----------------
3

Explanation-1:
------------
The unique patterns are as follows:
  1			1 1	    1 
1 1 1		  1 ,	1 1
  1	   ,	
   
   
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
5

Explanation-2:
------------
The unique patterns are as follows:
1 1		1 1		    1		1 1	,	1
1   ,     1 ,	    1 1 ,		

*/

public class DSAprogram1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // rows
        int n = sc.nextInt(); // columns
        
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(countUniquePatterns(grid, m, n));
        sc.close();
    }
    
    public static int countUniquePatterns(int[][] grid, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        Set<String> uniquePatterns = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<int[]> pattern = new ArrayList<>();
                    dfs(grid, i, j, visited, pattern, i, j);
                    
                    // Normalize the pattern for comparison
                    String normalizedPattern = normalizePattern(pattern);
                    uniquePatterns.add(normalizedPattern);
                }
            }
        }
        
        return uniquePatterns.size();
    }
    
    private static void dfs(int[][] grid, int i, int j, boolean[][] visited, 
                           List<int[]> pattern, int baseRow, int baseCol) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Check boundaries and if cell is valid
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        
        // Mark as visited
        visited[i][j] = true;
        
        // Add to pattern (store relative positions)
        pattern.add(new int[]{i - baseRow, j - baseCol});
        
        // Explore in all 4 directions
        dfs(grid, i + 1, j, visited, pattern, baseRow, baseCol); // down
        dfs(grid, i - 1, j, visited, pattern, baseRow, baseCol); // up
        dfs(grid, i, j + 1, visited, pattern, baseRow, baseCol); // right
        dfs(grid, i, j - 1, visited, pattern, baseRow, baseCol); // left
    }
    
    private static String normalizePattern(List<int[]> pattern) {
        // Sort the pattern to ensure consistent representation
        Collections.sort(pattern, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        // Normalize to make (0,0) the origin
        int minRow = pattern.get(0)[0];
        int minCol = Integer.MAX_VALUE;
        
        for (int[] point : pattern) {
            minCol = Math.min(minCol, point[1]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int[] point : pattern) {
            int normRow = point[0] - minRow;
            int normCol = point[1] - minCol;
            sb.append(normRow).append(",").append(normCol).append(";");
        }
        
        return sb.toString();
    }
}