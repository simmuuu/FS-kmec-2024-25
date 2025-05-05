/*
Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]


*/

import java.util.*;

public class DSAprogram2 {
    public static List<String> sol(String s) {
        List<List<String>> grps = new ArrayList<>();
        int i = 0;

        while(i < s.length()) {
            if(s.charAt(i) == '[') {
                int j = i + 1;

                while(j < s.length() && s.charAt(j) != ']') j++;
                String[] grp = s.substring(i + 1, j).split(","); 
                grps.add(Arrays.asList(grp));

                i = j + 1;
            } else {
                grps.add(new ArrayList<>(List.of(s.substring(i, i + 1))));
                i++;
            }
        }

        System.out.println(grps);
        List<String> res = new ArrayList<>();
        bt(grps, new StringBuilder(), res, 0);
        Collections.sort(res);
        return res;
    }

    private static void bt(List<List<String>> grps, StringBuilder s, List<String> res, int idx) {
        if(idx == grps.size()) {
            res.add(s.toString());
            return;
        }

        List<String> grp = grps.get(idx);
        for(String c: grp) {
            System.out.println(c);
            s.append(c);
            bt(grps, s, res, idx + 1);
            s.delete(s.length() - c.length(), s.length());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();

        System.out.println(sol(inp));
    }
}