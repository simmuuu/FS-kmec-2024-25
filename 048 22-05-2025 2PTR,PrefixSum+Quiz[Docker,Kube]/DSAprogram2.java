/*
Mr Robert is working with strings.
He selected two strings S1 and S2, may differ in length,
consists of lowercase alphabets only.

Mr Robert has to update the strings S1, S2 to meet any one of the criteria:
	- All the alphabets in S1 should be less than all the alphabets in S2.
	- All the alphabets in S2 should be less than all the alphabets in S1.
	- Both S1 and S2 should have only one distinct alphabet in it.
To Achieve, one of the criteria, you are allowed to replace any one letter in 
the string with any other lowercase alphabet.

Your task is to help Mr Robert, to find the minimum replacements to be done to 
update the strings S1 and S2 to meet one of the criteria mentioned above.


Input Format:
-------------
Two space separated strings S1 and S2.

Output Format:
--------------
Print an integer, minimum number of replacements.


Sample Input-1:
---------------
apple ball

Sample Output-1:
----------------
3

Explanation:
------------
Consider the best way to make the criteria true:
- Update S2 to "baaa" in 2 replacements, and Update S1 to "cpple" in 1 replacement
then every alphabet in S2 is less than every alphabet in S1.
        (OR)
- Update S1 to "ppppp" in 3 replacements, then every alphabet in S2 is less 
than every alphabet in S1.


Sample Input-2:
---------------
kmit kmec

Sample Output-2:
----------------
2
*/

import java.util.*;

public class DSAprogram2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S1 = sc.next();
        String S2 = sc.next();

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : S1.toCharArray()) freq1[c-'a']++;
        for (char c : S2.toCharArray()) freq2[c-'a']++;
        

        int len1 = S1.length();
        int len2 = S2.length();
        int minOps = Integer.MAX_VALUE;
        // c3
        for (int i=0; i<26; i++) {
            for (int j=0; j<26; j++) {
                int ops = (len1 - freq1[i]) + (len2 - freq2[j]);
                minOps = Math.min(minOps, ops);
            }
        }
        

        int[] prefix1 = new int[27];
        int[] prefix2 = new int[27];
        for (int i=0; i<26; i++) {
            prefix1[i + 1] = prefix1[i] + freq1[i];
            prefix2[i + 1] = prefix2[i] + freq2[i];
        }

        // c1,2
        for (int i=1; i<26; i++) {
            int ops1 = len1-prefix1[i] + prefix2[i]; // s1 < s2
            int ops2 = len2-prefix2[i] + prefix1[i]; // s2 < s1
            minOps = Math.min(minOps, Math.min(ops1, ops2));
        }

        System.out.println(minOps);
    }
}
