/*
Ramesh and Suresh are best friends. 
They decided to play a word game.

The game rules are as follows:
	- The game board shows a word W consist of two characters only A and B.
	- You are allowed to replace a pair of neighbour letters AA with BB in W.
	- Finally, The one who failed to replace the letters will lose the game.

You can assume that Ramesh will start playing the game always.

Your task is to determine if Ramesh can guarantee a win.
Print 'true', if Ramesh guarantee a win, otherwise, print 'false'.

Input Format:
-------------
A string W, word.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
AAABAAAA

Sample Output-1:
----------------
true

Explanation:
------------
Given word is AAABAAAA 
Ramesh -> AAABBBAA 
Now whatever the pair Suresh replaced with BB, 
one more replace is possible for Ramesh
So, there is a guarantee for Ramesh to win.

Sample Input-2:
---------------
AAAAAA

Sample Output-2:
----------------
true


Sample Input-3:
---------------
AAABAAA

Sample Output-3:
----------------
false

*/

import java.util.*;

public class DSAprogram2 {
    private static boolean sol(String s) {
        // First approach: Try the backtracking solution
        return canWin(s, true); // Ramesh starts (isRameshTurn = true)
    }

    private static boolean canWin(String s, boolean isRameshTurn) {
        System.out.println(s);
        // Try all possible moves (replacing AA with BB)
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'A' && s.charAt(i + 1) == 'A') {
                // Make the move: replace AA with BB
                String nextState = s.substring(0, i) + "BB" + s.substring(i + 2);
                
                System.out.println(i + " " + nextState + " " + isRameshTurn);
                // If current player is Ramesh and this move leads to a win, return true
                // If current player is Suresh and this move leads to a loss for Ramesh, return false
                boolean result = canWin(nextState, !isRameshTurn);
                
                if (isRameshTurn && result) {
                    return true; // Ramesh found a winning move
                }
                if (!isRameshTurn && !result) {
                    return false; // Suresh found a move that makes Ramesh lose
                }
            }
        }
        
        // If no AA pattern found, current player loses
        // If it's Ramesh's turn, he loses; if it's Suresh's turn, Ramesh wins
        return !isRameshTurn; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(sol(s));
    }
}

/*
import java.util.*;

public class program {
    private static boolean sol(String s) {
        return canWin(s);
    }

    private static boolean canWin(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) =='A' && s.charAt(i + 1) == 'A') {
                String nextState = s.substring(0, i) +"BB"+ s.substring(i + 2);
                if(!canWin(nextState)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(sol(s));
    }
}
*/