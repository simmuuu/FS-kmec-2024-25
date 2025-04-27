/*
Nehanth, a bubbly kid playing with digits and creating numbers using them.
The kid is creating the number called successive number. 
A number is called successive number, if and only if 
each digit in the number is one less than the next digit.

You are given two integers, start and end, both are inclusive.
Your task to find and print all the successive numbers in the given range (start, end).

Input Format:
-------------
Two space separated integers, start and end

Output Format:
--------------
Print the list of successive numbers in the range(start, end).


Sample Input-1:
---------------
50 150

Sample Output-1:
----------------
[56, 67, 78, 89, 123]


Sample Input-2:
---------------
100 600

Sample Output-2:
----------------
[123, 234, 345, 456, 567]

*/

import java.util.*;

public class DSAprogram3 {
    public static List<Integer> sol(int l, int r) {
        List<Integer> al = new ArrayList<>();

        int lLen = String.valueOf(l).length();
        int rLen = String.valueOf(r).length();

        for(int len = lLen; len <= rLen; len++) {
            for(int start = 1; start <= 9; start++) {
                if(start + len - 1 <= 9) {
                    int num = 0;

                    for(int i = 0; i < len; i++) {
                        int digit = start + i;
                        num = num * 10 + digit;
                    }

                    if(l <= num && num <= r) al.add(num);
                }
            }
        }

        return al;
    }

    // private static boolean isSuccessive(int n) {
    //     String s = String.valueOf(n);

    //     for(int i = 0; i < s.length() - 1; i++) {
    //         int a = s.charAt(i) - '0';
    //         int b = s.charAt(i + 1) - '0';

    //         if(a + 1 != b) return false;
    //     }

    //     return true;
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(sol(l, r));
    }
}