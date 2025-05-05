/*
Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false
*/

import java.util.*;

public class DSAprogram1 {
    private static boolean sol(String s1, String s2) {
        // track char -> substring
        Map<Character, String> hm = new HashMap<>();
        return bt(s1, 0, s2, 0, hm);
    }

    private static boolean bt(String s1, int idx1, String s2, int idx2, 
                              Map<Character, String> hm) {
        if(idx1 == s1.length() && idx2 == s2.length()) {
            System.out.println(hm);
            return true;
        }
        if(idx1 == s1.length() || idx2 == s2.length()) return false;

        char currchar = s1.charAt(idx1);

        if(hm.containsKey(currchar)) {
            String actualString = hm.get(currchar);

            if(idx2 + actualString.length() > s2.length()) return false;

            String s2SubString = s2.substring(idx2, idx2 + actualString.length());

            if(actualString.equals(s2SubString)) {
                return bt(s1, idx1 + 1, s2, idx2 + actualString.length(), hm);
            } else {
                return false;
            }
        }

        for(int len = 1; len <= s2.length() - idx2; len++) {
            String subString = s2.substring(idx2, idx2 + len);

            hm.put(currchar, subString);

            if(bt(s1, idx1 + 1, s2, idx2 + len, hm)) return true;

            hm.remove(currchar);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(sol(s1, s2));
    }
}


/*
Intiution:

Basic Concept
The key idea of backtracking here is to try different substring lengths for each character in S1 and "backtrack" if a particular choice doesn't work.

Steps to Consider:
Starting Point:

Create a HashMap to store character-to-substring mappings
Start recursion from index 0 of S1 and index 0 of S2
The Recursive Function:

Parameters: current position in S1, current position in S2, and the mapping HashMap
Base case: If you've processed all of S1 and all of S2, return true
The Backtracking Process:

For the current character in S1, check if it already has a mapping
If yes, verify that the corresponding substring appears at the current position in S2
If no, try different length substrings starting from the current position in S2
Decision Points:

If the current character in S1 is already mapped:

Check if the next portion of S2 matches this mapping
If it matches, move forward in both strings
If not, this path fails
If the character isn't mapped yet:

Try substrings of different lengths (from position to end of S2)
For each candidate substring, check if it's already mapped to another character
If not mapped, temporarily assign it and continue recursion
If the recursion fails, undo the mapping (backtrack) and try a different length
Pruning:

If S2 is shorter than the remaining characters in S1 need, stop that branch
If you've used all of S2 but haven't processed all of S1, stop that branch
This approach systematically tries all possible ways to map characters to substrings, backing out of invalid paths as soon as they're detected.
*/