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

import java.util.*;

public class DSAprogram3 {
    public static void sol(int row) {
        List<List<Integer>> l = genPascal(row);

        for(int i: l.get(row)) {
            System.out.print(i + " ");
        }
    }

    private static List<List<Integer>> genPascal(int n) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(List.of(1));

        for(int i = 1; i <= n; i++) { // row
            List<Integer> rowList = new ArrayList<>();

            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) rowList.add(1);
                else {
                    rowList.add(l.get(i - 1).get(j) + l.get(i - 1).get(j - 1));
                }
            }

            l.add(rowList);
        }

        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        sol(row);

        sc.close();
    }
}