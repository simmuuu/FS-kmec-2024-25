/*
Ram and Bheem are using a Desktop Computer.One day they found that keyboard 
is defective in which if you type backspace button,it will print '$', 
instead of removing one previous character.

Bheem and Ram have tried to type one word each on the same keyboard.
Return true, if both tried to type the same word. Otherwise return false.

Note:backspace for an empty text will continue empty.

Input Format:
-------------
Line-1:Two space seperated strings represents words w1,w2.

 
Output Format:
--------------
Print a boolean result.
 
Constraints:

    1 <= w1.length, w2.length <= 200
    w1 and w2 only contain lowercase letters and '$' characters.


 
Sample Input-1:
---------------
pq$r  pt$r

Sample Output-1:
----------------
true

Explanation:
------------
Both wants to type 'pr'

Sample Input-2:
---------------
se$$at cea$$t

Sample Output-2:
----------------
false

Sample Input-3:
---------------
s$$at ce$$at

Sample Output-2:
----------------
true

Explanation:
------------
Both wants to type 'at'.
*/

import java.util.*;

public class DSAprogram2 {
    private static boolean sol(String s1, String s2) {
        Stack<Character> st1 = new Stack<>();
        for(char c: s1.toCharArray()) {
            if(c != '$') st1.push(c);
            else if(!st1.isEmpty()) st1.pop();
        }

        Stack<Character> st2 = new Stack<>();
        for(char c: s2.toCharArray()) {
            if(c != '$') st2.push(c);
            else if(!st2.isEmpty()) st2.pop();
        }

        return st1.equals(st2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        
        System.out.println(sol(s1, s2));
        sc.close();
    }
}