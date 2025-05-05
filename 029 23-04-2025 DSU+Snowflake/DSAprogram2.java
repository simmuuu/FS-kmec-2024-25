/*
You are a database integrity engineer working for a global cloud company. 
Your team maintains a distributed database network, where each server either:
    - Stores equivalent data to another server (serverX == serverY).
    - Stores different data from another server (serverX != serverY).

The transitive consistency rule must be followed:
    - If A == B and B == C, then A == C must be true.
    - If A == B and B != C, then A != C must be true.

Your task is to analyze the given constraints and determine whether they 
follow transitive consistency. If all relations are consistent, return true; 
otherwise, return false

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false

Explanation:
------------
{a, b} form one equivalence group.
{c} is declared equal to {a} (c == a), which means {a, b, c} should be equivalent.
However, b != c contradicts b == a and c == a.

Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true

*/

import java.util.*;

public class DSAprogram2 {
    public static boolean sol(String[] inp) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;

        for (String relation : inp) {
            if (relation.charAt(1) == '=') {
                union(parent, relation.charAt(0) - 'a', relation.charAt(3) - 'a');
            }
        }
        // System.out.println(Arrays.toString(parent));

        for (String relation : inp) {
            if (relation.charAt(1) == '!') {
                if (find(parent, relation.charAt(0) - 'a') == find(parent, relation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        
        return true; 
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]); 
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int rx = find(parent, x);
        int ry = find(parent, y);
        if(rx < ry) parent[ry] = rx;
        else parent[rx] = ry;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");

        System.out.println(sol(inp));
    }
}