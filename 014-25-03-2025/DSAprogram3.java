/*
You are given a list of positive integers List[].
You need to findout the product P as (List[i]-1)*(List[j]-1).
Where P should be the largest possible value, 
and i, j are the postions of the two different elements in the List.

Input Format:
-------------
Line-1: An integer N, number of elemenets of the list.
Line-2: N space separated integers, List[], where list[i] >0

Output Format:
--------------
Print an integer, P


Sample Input-1:
---------------
4
3 4 5 2

Sample Output-1:
----------------
12


Sample Input-2:
---------------
4
2 5 4 5

Sample Output-2:
----------------
16
*/

import java.util.*;

public class DSAprogram3 {
    private static int sol(int[] nums, int n) {
        Arrays.sort(nums);

        return Math.max((nums[0]-1) * (nums[1]-1), (nums[n - 1]-1) * (nums[n - 2]-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sol(nums, n));

        sc.close();
    }
}