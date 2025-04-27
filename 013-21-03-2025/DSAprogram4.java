/*
A digit sum is the sum of all the digits of a number.
e.g., 123=> 1 + 2 + 3 => 6, So, digit sum of 123 is 6.

You are given an integer N. 
Find the digit sum of each number from 1 to N.
And group them according to their digit sum.

Your task is to find and print the number of groups have the largest size.

Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer, number of groups with largest size.

Sample Input-1:
---------------
13

Sample Output-1:
----------------
4

Explanation:
------------
There are 9 groups formed: [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. 
There are 4 groups having largest size-2.


Sample Input-2:
---------------
24

Sample Output-2:
----------------
5
*/

import java.util.*;

public class DSAprogram4 {
    public static int sol(int n) {
        Map<Integer, Integer> m = new HashMap<>();
        int max = 0;

        for(int i = 1; i <= n; i++) {
            int digitSum = sumDigit(i);
            m.put(digitSum, m.getOrDefault(digitSum, 0) + 1);

            max = Math.max(max, m.get(digitSum));
        }

        int count = 0;
        for(int val: m.values()) {
            if(val == max) count++;
        }

        return count;
    }

    private static int sumDigit(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(sol(n));
        sc.close();
    }
}