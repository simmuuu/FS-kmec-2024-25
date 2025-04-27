/*
In the context of linguistic harmony, we define a "harmonious string" as a string where 
every alphabet it contains appears both in uppercase and lowercase forms. For instance, 
a string like "pqQpP" is harmonious because it has both 'P' and 'p' as well as 'Q' and 'q'. 
Conversely, a string like "pqP" is not harmonious as it fails to meet this condition, 
with 'q' present while 'Q' is absent.

Your are given a string S, your task is  to return the longest harmonious substring in S. 
If there are multiple answers meeting this criterion, you should return the one that appears 
earliest in the string. If there is no harmonious substring, you should return an empty string.

Input Format:
-------------------
A string S

Output Format:
-------------------
Prin the longest harmonious string.


Sample Input:
--------------
QcvcCcq

Sample Output:
---------------
cCc


Sample Input:
--------------
pqrs

Sample Output:
--------------
""
*/

import java.util.*;

public class DSAprogram1 {
    private static boolean isHarmonious(String s) {
        for(char c: s.toCharArray()) {
            if(Character.isUpperCase(c)) {
                if(s.indexOf(c + 32) == -1) {
                    return false;
                }
            } else {
                if(s.indexOf(c - 32) == -1) {
                    return false;
                }
            }
        }

        return true;
    }

    // bruteforce
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();

        int maxLen = 0;
        String res = "";
        for(int i = 0; i < inp.length(); i++) {
            for(int j = i + 1; j < inp.length(); j++) {
                String s = inp.substring(i, j + 1);
                if(s.length() > maxLen && isHarmonious(s)) {
                    maxLen = s.length();
                    res = s;
                }
            }
        }
    
        System.out.print(res);


        sc.close();
    }
}