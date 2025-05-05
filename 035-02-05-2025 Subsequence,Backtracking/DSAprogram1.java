/*
You are given an array ar[], find the closed subsequence in which we subtract 
the largest and smallest element in the subsequence, the result is equal to 1.

Your task is to return the length of its greatest closed subsequence among all
its possible subsequences.

A subsequence of array is a sequence that can be taken from the array by removing 
some or no elements without changing the order of the remaining elements.

Input Format:
-------------
Line-1: An integer n number of elements.
Line-2: n space separated integers represent the elements.
 
Output Format:
--------------
Print an integer.
 
Constraints:
 1 <= n <= 10^4
-10^4 <= ar[i] <= 10^4

 
Sample Input-1:
---------------
6
4 3 5 2 6 3
 
Sample Output-1:
----------------
3

Explanation:
------------
Subsequence is [4,3,3]
 
Sample Input-2:
---------------
7
20 19 19 29 37 35 19

Sample Output-2:
----------------
4

Explanation:
------------
Subsequence is [20 19 19 19]
*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        sc.close();
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:a){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        int max=0;
        for(int i:m.keySet()){
            if(m.containsKey(i+1)){
                max=Math.max(max,m.get(i)+m.get(i+1));
            }
        }
        System.out.println(max);
    }
}