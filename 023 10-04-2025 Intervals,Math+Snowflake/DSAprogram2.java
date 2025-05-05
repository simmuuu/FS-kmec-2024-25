/*
Pascal's Triangle looks like below:
			1
		  1  1
		1  2  1
	  1  3  3  1
ans so on... You can create N number of rows, rows are indexed from 0 onwards.

You are given an integer N,
Your task is to print N-th index Row of the Pascal's Triangle.

Input Format:
-------------
An integer N, index number.

Output Format:
--------------
Print the n-th index row of Pascal's Triangle.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
1 1


Sample Input-2:
---------------
3

Sample Output-2:
----------------
1 3 3 1

*/

// formula and repeated.

import java.util.*;

public class DSAprogram2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // c * (i - j + 1) / j
        long c = 1;
        for(int i = 1; i <= n; i++) {
            System.out.print(c + " ");
            c = (c*(n - i + 1)) / i;
        }
        System.out.println(1);
    }
}