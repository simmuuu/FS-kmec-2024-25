/*
In a shopping mall, there are some vouchers available, and they have open the 
online booking of the slots to collect the vouchers. And cost of each slot may 
vary time to time and the cost is printed on the voucher.

There are a total of N slots booked to collect the vouchers.
Some customers booked more than one slot, where some slots are immediate and 
some or not. After bookings are done, The management announced the
following conditions:
- The customer is allowed to collect the vouchers one at a time and not immediately.
- And every customer is identified by an unique alphabet.
- The management will refund the cost of the booked slots which are not used.

You will be given the slots order based on customer-id, and 
the cost of the slots accordingly to the above order.
Each customer identified by an unique ID, an alphabet (only lowercase).

Your task is to help the management, to find the minimum amount to be paid
as refund to the customers.

NOTE: If a customer booked 3 slots immediately, he/she will be given only one 
voucher and the cost of other two slots will be refunded.


Input Format:
-------------
Line-1: A string S.
Line-2: S.length() space separated integers, penalty[] points.

Output Format:
--------------
Print an integer, the minimum amount to be refund.


Sample Input-1:
---------------
abcccb
3 5 2 7 4 3

Sample Output-1:
----------------
6

Explanation:
------------
There are two slots which are not used by customer-c 
and the cost of immediate slots booked by customer-c are [2,7,4].
So, minimum refund is 2 + 4= 6


Sample Input-2:
---------------
pqrs
3 2 5 2

Sample Output-2:
----------------
0


Sample Input-3:
---------------
llmjjkjj
5 2 4 6 2 6 4 7

Sample Output-3:
----------------
8

Explanation:
------------
There is one slot not used by customer-l
There is two slots not used by customer-j
The cost of the slots booked by customer-l are [5,2]
The cost of the slots booked by customer-j are [6,2], [4,7]
So, minimum refund is 2 + 2 + 4 = 8

*/

import java.util.*;

public class DSAprogram1 {
    private static int sol(char[] cust, int[] refund) {
        int res = 0;
        
        for(int i = 1; i < cust.length; i++) {
            if(cust[i] == cust[i - 1]) {
                int max = refund[i - 1];
                int sum = refund[i - 1];
                
                while(i < cust.length && cust[i] == cust[i - 1]) {
                    max = Math.max(max, refund[i]);
                    sum += refund[i];
                    i++;
                }

                res += (sum - max);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] cust = sc.nextLine().toCharArray();
        int[] refund = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sol(cust, refund));
    }
}