# Minimum Starting Amount to Visit All Shops

You are given an array `amounts` representing the cost of visiting each shop in order, and an integer `c` representing a coupon value.

The rules are:
1. You must visit the shops in the order they appear in the array.
2. To visit shop `i`, you must have already visited shop `i-1` (except for the first shop).
3. You need to pay `amounts[i]` rupees to visit the `i`-th shop.
4. You can use a coupon of value `c` rupees exactly once to reduce the payment for any single shop (i.e., pay `amounts[i] - c` for that shop). If the coupon value exceeds the shop's cost, you still pay 0 (not negative).
5. After each shopping transaction, you must have at least 1 rupee remaining.
6. At the end of visiting all shops, you must have at least 1 rupee remaining.

Return the minimum initial amount of rupees needed to visit all shops while following the above rules.

## Example 1:
```
Input: amounts = [2, 3, 5], c = 2
Output: 8
Explanation: 
Start with 8 rupees.
Visit shop 0: Pay 2 rupees, balance = 6.
Visit shop 1: Pay 3 rupees, balance = 3.
Visit shop 2: Use coupon and pay 5-2=3 rupees, balance = 0.
Since we need at least 1 rupee at the end, we need 1 more rupee to start with.
So, the minimum starting amount is 9 rupees.
```

## Example 2:
```
Input: amounts = [5, 7, 2, 4], c = 3
Output: 16
Explanation:
Start with 16 rupees.
Visit shop 0: Pay 5 rupees, balance = 11.
Visit shop 1: Use coupon and pay 7-3=4 rupees, balance = 7.
Visit shop 2: Pay 2 rupees, balance = 5.
Visit shop 3: Pay 4 rupees, balance = 1.
We have 1 rupee at the end, which satisfies the requirement.
```
