/*

https://leetcode.ca/all/276.html

You are organizing a grand parade where 'N' marching bands will move in a
straight line. Each band must wear uniforms of exactly one color chosen from 'K'
available colors. To keep the parade visually appealing and avoid monotony, you
must follow this important guideline:

- No more than 'two consecutive bands' can wear 'uniforms of the same color'.

Given the total number of bands N and the number of uniform color choices K,
determine the total number of valid ways you can assign uniform colors to all 
bands so that the above rule is not violated.

Input Format:
-------------
Two integers N and K.

Output Format:
--------------
Print an integer, Number of ways.

Example 1:  
----------
Input: 
3 2
Output:
6  

Explanation:
------------
Bands	band-1	band-2	band-3
----- 	----- 	----- 	-----
1		c1 		c1		c2
2		c1 		c2 		c1
3		c1 		c2 		c2
4		c2 		c1 		c1
5		c2 		c1 		c2
6		c2 		c2 		c1

Example 2:  
----------
Input: 
1 1
Output: 
1


Constraints:  
- 1 <= n <= 50  
- 1 <= k <= 10^5 
- The result will always be within the range of a 32-bit signed integer.

*/

import java.util.*;

public class DSAprogram1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        // System.out.println(sol(new int[n], n, k, 0));
        int dp[][] = new int[n + 1][2];

        dp[1][0] = k;
        dp[1][1] = 0;
        System.out.println("1: " + Arrays.toString(dp[1]));

        for(int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
            dp[i][1] = dp[i - 1][0];
            System.out.println(i + ": " + Arrays.toString(dp[i]));
        }

        

        System.out.println(dp[n][0] + dp[n][1]);
    }
    
    // bruteforce
    private static int sol(int[] bands, int n, int k, int idx) {
        if(idx == n) {
            if(valid(bands)) return 1;
            return 0;
        }

        int count = 0;
        for(int i = 1; i <= k; i++) {
            bands[idx] = i; 
            count += sol(bands, n, k, idx + 1);
        }
        return count;
    }

    private static boolean valid(int[] bands) {
        for(int i = 2; i < bands.length; i++) {
            if(bands[i] == bands[i - 1] && bands[i] == bands[i - 2]) return false;
        }
        return true;
    }
}