/*
Weekend Venkat Rao visits a nightclub where a game is being organized to win 
as much gold as possible.

He starts the game with:
	- An initial amount of money X.
	- An initial gold count of 0.
	- A list of N coupons, where each coupon has a value coupon[i].

Game Rules:
Venkat Rao can choose to play any coupon at most once, and in any order. 
For each coupon, he has two options:

1. Play as Head: If his current amount is greater than or equal to coupon[i], 
he can: 
	- Spend coupon[i] amount of money.
	- Gain 1 gold.

2. Play as Tail: If he has at least 1 gold, he can:
	- Spend 1 gold.
	- Gain coupon[i] amount of money.

The goal is to maximize the total gold Venkat Rao can earn after playing zero 
or more coupons.

Input Format:
-------------
Line-1: Two integers N and X, N number of coupons, and intial amount X.
Line-2: N space separated integers, amounts on the coupons. 

Output Format:
--------------
Print an integer, maximum gold earned by Weekend Venkat Rao.


Sample Input-1:
---------------
2 75
50 100


Sample Output-1:
----------------
1

Explanation:
-------------
Play the 0 coupon (50) to head, your amount becomes 50 and gold becomes 1.
There is no need to play the 1 coupon since you cannot play it head to add to your gold.
	

Sample Input-2:
---------------
4 50
25 50 75 100

Sample Output-2:
----------------
2

Explanation:
-------------
Play the coupons in this order to get a gold of 2units:
- Play the 0 coupon (25) to head, your amount becomes 25 and gold becomes 1.
- Play the 3 coupon (100) to tail, your amount becomes 125 and gold becomes 0.
- Play the 1 coupon (50) to head, your amount becomes 75 and gold becomes 1.
- Play the 2 coupon (75) to head, your amount becomes 0 and gold becomes 2.
*/

import java.util.*;

/**
 * This program solves the Weekend Venkat Rao's gold maximization problem:
 * - Start with initial money and no gold
 * - For each coupon, either:
 *   1. Spend money equal to coupon value to gain 1 gold (play as Head)
 *   2. Spend 1 gold to gain money equal to coupon value (play as Tail)
 * - The goal is to maximize gold
 */
class program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input
        int numCoupons = scanner.nextInt();
        int initialMoney = scanner.nextInt();
        
        int[] couponValues = new int[numCoupons];
        for (int i = 0; i < numCoupons; i++) {
            couponValues[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Sort coupon values in ascending order
        // This allows us to use smaller coupons for Head (spend money) first
        // and larger coupons for Tail (gain money) first
        Arrays.sort(couponValues);
        
        int maxGold = 0;         // Track maximum gold obtained
        int currentGold = 0;     // Current gold count
        int currentMoney = initialMoney; // Current money amount
        
        // Two-pointer approach:
        // - Left pointer (i) for playing as Head (spending money)
        // - Right pointer (j) for playing as Tail (gaining money)
        int leftPointer = 0, rightPointer = numCoupons - 1;
        
        while (leftPointer <= rightPointer) {
            // Option 1: Play as Head if we have enough money
            if (couponValues[leftPointer] <= currentMoney) {
                currentMoney -= couponValues[leftPointer];
                currentGold++;
                leftPointer++;
            } 
            // Option 2: Play as Tail if we have at least 1 gold
            else if (currentGold > 0) {
                currentMoney += couponValues[rightPointer];
                currentGold--;
                rightPointer--;
            } 
            // If we can't do either, we're done
            else {
                break;
            }
            
            // Update the maximum gold we've seen so far
            maxGold = Math.max(maxGold, currentGold);
        }
        
        // Print the result
        System.out.println(maxGold);
    }
}
