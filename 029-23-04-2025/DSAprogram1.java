
/*
In the world of secret codes and cryptography, you are entrusted with deciphering a hidden message. 
You have two encoded keys, key1 and key2, both of equal length. Each character 
in key1 is paired with the corresponding character in key2. 

This relationship follows the standard rules of an equivalence cipher:
• Self-Mapping: Every character inherently maps to itself.  
• Mutual Mapping: If a character from key1 maps to one in key2, then that 
  character in key2 maps back to the one in key1.  
• Chain Mapping: If character A maps to B, and B maps to C, then A, B, and C 
  are all interchangeable in this cipher.

Using this mapping, you must decode a cipherText, by replacing every character 
with the smallest equivalent character from its equivalence group. 
The result should be the relatively smallest possible decoded message.


Input Format:
-------------
Three space separated strings, key1 , key2 and cipherText

Output Format:
--------------
Print a string, decoded message which is relatively smallest string of cipherText.

Example 1: 
input=
attitude progress apriori
output=
aaogoog


Explanation: The mapping pairs form groups: [a, p], [o, r, t], [g, i], [e, u], 
[d, e, s]. By substituting each character in cipherText with the smallest from 
its group, you decode the message to "aaogoog".


Constraints:  
• 1 <= key1.length, key2.length, cipherText.length <= 1000  
• key1.length == key2.length  
• key1, key2, and cipherText consist solely of lowercase English letters.

*/

import java.util.*;

public class DSAprogram1 {
    public static void sol(String k1, String k2, String chiper) {
        int[] parent = new int[26];
        for(int i = 0; i < 26; i++) parent[i] = i;

        for(int i = 0; i < k1.length(); i++) {
            union(parent, k1.charAt(i) - 'a', k2.charAt(i) - 'a');
        }

        for(int i = 0; i < chiper.length(); i++) {
            System.out.print((char) (find(parent, chiper.charAt(i) - 'a') + 'a'));
        }
    }

    private static int find(int[] parent, int x) {
        if(parent[x] != x) return find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int xp = find(parent, x);
        int yp = find(parent, y);

        if(xp < yp) parent[yp] = xp;
        else parent[xp] = yp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");

        String k1 = inp[0];
        String k2 = inp[1];
        String chiper = inp[2];

        sol(k1, k2, chiper);
    }
}