/* 
'''
In Turkey, an ice cream parlour given an offer to a lucky kid.
The parlour keep N icecream cups in a row, and there are different flavours 
of icecreams, where i-th cup filled with the flavour[i] type of ice cream.

The kid can pick the continuous set of ice cream cups, where the cups filled
with the icecreams of atmost two different flavours. The kid wants to 
pick maximum number of icecream cups from the row.

You will be given the integer array, flavours[] of size N.
Your task is to help the kid to pick the maximum number of icecream cups 
with atmost two different flavours.


Input Format:
-------------
Line-1: An integer, number of icecreams.
Line-2: N space separated integers, flavours[] 

Output Format:
--------------
Print an integer result, maximum number of icecream cups can be picked.


Sample Input-1:
---------------
10
1 2 3 1 1 3 3 2 3 2

Sample Output-1:
----------------
5

Explanation:
------------
The kid can pick the continuous set of icecream cups as follows: 3 1 1 3 3
Where the cups are filled with two different flavours, 1 and 3.



Sample Input-2:
---------------
10
2 1 1 3 2 1 3 0 0 3

Sample Output-2:
----------------
4

*/

import java.util.*;

public class DSAprogram1 {
    private static int sol(int n, int[] nums) {
        int res = 1;
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0, j = 0; j < n; j++) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);   

            while(hm.size() > 2) {
                int flav = nums[i];
                hm.put(flav, hm.get(flav) - 1);

                if(hm.get(flav) == 0) hm.remove(flav);
                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sol(n, nums));
    }
}