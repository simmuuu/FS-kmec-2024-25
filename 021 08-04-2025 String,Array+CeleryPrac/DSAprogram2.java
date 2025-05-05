 /*
There are N laddus placed in a row. Each laddu has an ID printed on it.
IDs are printed in ascending order like as follows: S, S+1, S+2,...,E-2, E-1, E, 
where N = E-S+1.

Chota Bheem ate K number of laddus randomly from the row. You are given 
three integers K, S, E, and the IDs of the laddus eaten given as eaten[] array
in ascending order.

Your task is to find the ranges of IDs on the laddus remained in the row,
and print all the ranges as shown in the samples.

For example:
Given the IDs of the laddus eaten: [ 1, 2, 4, 51, 52, 53, 92, 93, 94, 95]
and S=1 E=100. The ranges of IDs of laddus which are remained in the row: 
[3, 5:50, 54:91, 96:100]

Note: The array eaten[] contains no duplicates.

Input Format:
-------------
Line-1: Three space separated integers, K, S and E.
Line-2: K space separated integers in sorted order, eaten[] IDs of laddus eaten.

Output Format:
--------------
Print the list of ID ranges in the row.


Sample Input-1:
---------------
9 0 20
0 1 2 3 4 5 8 9 10

Sample Output-1:
----------------
[6:7, 11:20]


Sample Input-2:
---------------
14 -50 50
-48 -47 -35 -20 -19 0 21 22 23 25 26 39 43 47

Sample Output-2:
----------------
[-50:-49, -46:-36, -34:-21, -18:-1, 1:20, 24, 27:38, 40:42, 44:46, 48:50]

*/

import java.util.*;

public class DSAprogram2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        sc.nextLine();
        int[] inp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<String> al = new ArrayList<>();

        if(l < inp[0]) {
            if(inp[0] - 1 == l) al.add(String.valueOf(l));
            else {
                al.add(l + ":" + String.valueOf(inp[0] - 1));
            }
        }

        for(int i = 1; i < n; i++) {
            if(inp[i] - inp[i - 1] > 1) {
                int start = inp[i - 1] + 1;
                int end = inp[i] - 1;

                if(start == end) {
                    al.add(String.valueOf(start));
                } else al.add(start + ":" + end);
            }
        }

        if(inp[n - 1] < r) {
            if(inp[n - 1] + 1 == r) al.add(String.valueOf(r));
            else {
                al.add((inp[n - 1] + 1) + ":" + r);
            }            
        }

        System.out.println(al);
    }
}