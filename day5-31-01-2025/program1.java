/*
You are given an integer array nums and two integers l and r. Your task is to 
analyze the volatility of a sequence of values. The volatility of a sequence is 
defined as the difference between the maximum and minimum values in that sequence.

You need to determine the sequence with the highest volatility among all 
sequences of length between l and r (inclusive).

Return the highest volatility. If no such sequence exists, return -1.

Input Format:
-------------
Line-1: 3 space separated integers, n, l, r
Line-2: n space separated integers, nums[].

Output Format:
-------------
An integer, the highest volatility.


Sample Input-1:
---------------
5 2 3
8 3 1 6 2

Sample Output-1:
----------------
7

Explanation:
------------
The possible sequences of length between l = 2 and r = 3 are:

[8, 3] with a volatility of 8−3=5
[3, 1] with a volatility of 3−1=2
[1, 6] with a volatility of 6−1=5
[8, 3, 1] with a volatility of 8−1=7
The sequence [8, 3, 1] has the highest volatility of 7.

Sample Input-2:
---------------
4 2 4
5 5 5 5

Sample Output-2:
----------------
0

Explanation:
------------
All possible sequences have no volatility as the maximum and minimum values 
are the same, resulting in a difference of 0.
 
*/

import java.util.*;

public class program1 {
    public static int sol(int[] arr, int l, int r) {
        int min = 0, max = 0;
        int left = 0;
        int res = -1;
        
        for(int win = l; win <= r; win++) {
            for(int right = left + win - 1; right < arr.length; right++) {
                if(right - left + 1 > win) {
                    left++;
                } 
                
                if(right - left + 1 == win) {
                    max = Arrays.stream(arr).max().getAsInt();
                    min = Arrays.stream(arr).min().getAsInt();
                    res = Math.max(res, max - min);
                }
            }
            
            left = 0;
        }
        
        return res;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        
        int[] inp = new int[n];
        for(int i = 0; i < n; i++) inp[i] = sc.nextInt();
        
        System.out.println(sol(inp, l, r));
    }
}