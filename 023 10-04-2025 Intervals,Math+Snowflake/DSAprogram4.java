/*
You can call two strings X and Y are friendly strings, 
if you can swap two letters in X, so the result is equal to Y.

The condition to swap the letters is as follows:
	Swapping letters is defined as taking two indices i and j (0-indexed) 
	such that i != j and swapping the characters at A[i] and A[j] . 
	For example, swapping at indices 0 and 2 in "abcd" results in "cbad" .

You are given two strings X and Y of lowercase letters, 
return true if X and Y are friendly strings, otherwise return false.

Input Format:
-------------
Two space separated Strings X and Y

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
abcde bacde

Sample Output-1:
----------------
true

Sample Input-2:
---------------
abcde abcde

Sample Output-2:
----------------
false

*/

import java.util.*;

public class DSAprogram4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next(), b = sc.next();

        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) count++;

            if(count > 2) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}