/*
Pramod plans to design a program that generates all possible valid IP addresses from a given string S.
It is guaranteed that S contains only digits.

Help Pramod by designing a program that returns all valid IP addresses generated from S.
The IP addresses must be printed in lexicographic order.

Note:

- A valid IP address consists of exactly four integers, each ranging from 0 to 255, separated by single dots (.).
- IP address segments cannot contain leading zeros.
- Valid IP addresses must fall within the range 0.0.0.0 to 255.255.255.255.

Examples of invalid IP addresses: 123.012.234.255, 123.234.345.34.

Input Format:
-------------
A string S, contains only digits [0-9].

Output Format:
--------------
Print all possible IP addresses which are valid.


Sample Input-1:
---------------
23323311123

Sample Output-1:
----------------
[233.233.11.123, 233.233.111.23]


Sample Input-2:
---------------
12345678

Sample Output-2:
----------------
[1.234.56.78, 12.34.56.78, 123.4.56.78, 123.45.6.78, 123.45.67.8]


Sample Input-3:
---------------
02550255

Sample Output-3:
----------------
[0.25.50.255, 0.255.0.255]
*/

import java.util.*;

public class DSAprogram1 {
    private static List<String> sol(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() > 12) return res;
        bt(0, 0, s, "", res);
        return res;
    }

    private static void bt(int idx, int dots, String s, String currIP, List<String> res) {
        if(dots > 4) return; // too many octets
        if(dots == 4 && idx == s.length()) { 
            res.add(currIP.substring(0, currIP.length() - 1)); // remove trailing dot
            return;
        }

        for(int i = idx; i < Math.min(idx + 3, s.length()); i++) { // for loop from 1-3(valid octet)
            if(i > idx && s.charAt(idx) == '0') continue; // if leading zero skip
            if(Integer.parseInt(s.substring(idx, i + 1)) < 256) { // check if valid octet
                bt(i + 1, dots + 1, s, currIP + s.substring(idx, i + 1) + ".", res);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sol(sc.nextLine()));
    }
}