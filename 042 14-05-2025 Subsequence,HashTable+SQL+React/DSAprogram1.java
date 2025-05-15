/*

Leetcode: https://leetcode.com/problems/maximum-number-of-removable-characters/description/

You are given two strings 'Org' and 'Sub' where Sub is a subsequence of Org. 
You aer given a list of R indices[] (Unique indices), and you need to delete 
P letters from the given string 'Org', with the following conditions:
    - You need to delete the first P letters from strin 'Org'in the given order
      of indices[] only.
    - After deleting P letters, the string 'Sub' should be subsequence of 'Org'.
      Where, 0 <= i < P and P < R.
     
Your task is to maximixe the value of P such that 'Sub' is still a subsequence 
of 'Org' after the deletion of letters, and return P.

Input Format:
-------------
Line-1: Two space seperated strings, Original and Sub
Line-2: An integer, R, number of indices.
Line-3: R space separated integers, indices[].

Output Format:
--------------
Print an integer, the maximum value of P.


Sample Input-1:
---------------
pqrprq pr
3
3 1 0

Sample Output-1:
----------------
2

Explanation:
------------
After deleting 2 letters at indices 3 and 1, "pqrprq" becomes "prrq".
"pq" is a subsequence of "prrq".
If you delete 3 letters at indices 3, 1, and 0, "pqrprq" becomes "rrq", 
and "pq" is not a subsequence of "rrq".
Hence, the maximum P is 2.

Sample Input-2:
---------------
pqrqssss pqrs
6
3 2 1 4 5 6

Sample Output-2:
----------------
1

Explanation: 
------------
After deleting 1 letter at index 3, "pqrqssss" becomes "pqrssss".
"pqrs" is a subsequence of "pqrssss".

*/

import java.util.*;

public class DSAprogram1 {
    private static int sol(String org, String sub, int[] idxs) {
        int res = 0;
        boolean[] visited = new boolean[org.length()];

        for(int i = 0; i < idxs.length; i++) {
            if(!isSub(org, sub, visited, idxs[i])) break;
            else res++;
        }

        return res;
    }
    
    private static boolean isSub(String org, String sub, boolean[] visited, int k) {
        visited[k] = true;
        int i = 0; 
        int j = 0;
        
        while (i < sub.length() && j < org.length()) {
            if (!visited[j] && sub.charAt(i) == org.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == sub.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String org = sc.next();
        String sub = sc.next();
        sc.nextLine();

        int n = sc.nextInt();
        int[] idxs = new int[n];

        for(int i = 0; i < n; i++) idxs[i] = sc.nextInt();
        System.out.println(sol(org, sub, idxs));
    }
}