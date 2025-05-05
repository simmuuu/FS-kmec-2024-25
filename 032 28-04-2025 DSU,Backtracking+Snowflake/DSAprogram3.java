/*
You are given a crystal with an energy level n. Your goal is to discover all 
the different ways this crystal could have been created by combining smaller shards.

Each combination must:
- Use only shards with energy values between 2 and n - 1.
- Be represented as a list of shard values whose product equals n.
- Use any number of shards (minimum 2), and the order is ascending order.

Your task is to return all unique shard combinations that can multiply together
to recreate the original crystal.

Example 1:
---------
Input:
28

Output:
[[2, 14], [2, 2, 7], [4, 7]]

Example 2:
----------
Input:
23

Output:
[]



Constraints:
- 1 <= n <= 10^4
- Only shards with energy between 2 and n - 1 can be used.

*/

import java.util.*;

public class DSAprogram3 {
    private static List<List<Integer>> sol(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> divisors = new ArrayList<>();
        for(int i = 2; i < n; i++) {
            if(n % i == 0) divisors.add(i);
        }

        bt(res, n, divisors, new ArrayList<>(), 1, 0);
        return res;
    }

    private static void bt(List<List<Integer>> res, int n, List<Integer> divisors, 
                            List<Integer> factors, int product, int start) {
        if(product == n) {
            res.add(new ArrayList<>(factors));
            return;
        }

        for(int i = start; i < divisors.size(); i++) {
            int d = divisors.get(i);
            if(product * d > n) return;
            
            factors.add(d);
            bt(res, n, divisors, factors, product * d, i);  
            factors.remove(factors.size() - 1);
        }
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(sol(n));
    }
}