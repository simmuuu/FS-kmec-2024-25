/*
"Emphatic Pronunciation" of a given word is where we take the word and
replicate some of the letter to emphasize their impact.

Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
We define emphatic pronunciation of a word, which is derived by replicating 
a group (or single) of letters in the original word. 

So that the replicated group is atleast 3 characters or more and 
greater than or equal to size of original group. 
For example Good -> Goood is an emphatic pronunciation,
but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
In the question you are given the "Emphatic pronunciation" word, 
you have to findout how many words can legal result in the 
"emphatic pronunciation" word.

Input Format:
-------------
Line-1 -> A String contains a single word, Emphatic Pronunciation word
Line-2 -> Space seperated word/s

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
goood
good goodd

Sample Output-1:
----------------
1

Sample Input-2:
---------------
heeelllooo
hello hi helo

Sample Output-2:
----------------
2
*/

import java.util.*;

class Pair {
    char c;
    int count;
    
    Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}

public class DSAprogram1 {
    public static boolean can(List<Pair> l, List<Pair> l1) {
        if (l.size() != l1.size()) return false;
        
        for (int i = 0; i < l.size(); i++) {
            Pair p = l.get(i);
            Pair p1 = l1.get(i);
            
            if (p.c != p1.c) return false;
            if (p.count == p1.count) continue;
            if (p.count < p1.count || p.count < 3) return false;
        }
        
        return true;
    }
    
    public static List<Pair> toList(String s) {
        List<Pair> l = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 1;
            
            while (i + 1 < s.length() && s.charAt(i + 1) == c) {
                i++;
                count++;
            }
            
            l.add(new Pair(c, count));
            i++;
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String words[] = sc.nextLine().split(" ");
        int res = 0;
        
        List<Pair> l = toList(s);
        
        for (String word : words) {
            List<Pair> wordList = toList(word);
            if (can(l, wordList)) {
                res++;
            }
        }
        
        System.out.print(res);
    }
}

/*
JOHN CODE
 * import java.util.*;

class emphaticWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        String[] words = s1.split(" ");
        int count = 0;
        int i = 0;
        while (i < words.length) {
            if (isValid(words[i], s)) {
                count++;
            }
            i++;
        }
        System.out.println(count);
    }

    public static boolean isValid(String word, String emphatic) {
        int n = word.length();
        int m = emphatic.length();
        int i = 0; int j = 0;
        while (i < n && j < m) {
            char wW = word.charAt(i);
            char eW = emphatic.charAt(j);
            if(wW != eW) return false;
            int wCount = 0, eCount = 0;
            while (i < n && word.charAt(i) == wW) {
                wCount++;
                i++;
            }
            while (j < m && emphatic.charAt(j) == eW) {
                eCount++;
                j++;
            }
            if (eCount >= 3 && wCount <= eCount)
                continue;
            else if (eCount < 3 && wCount == eCount)
                continue;
            else return false;
        }
        return i == n  && j == m;
    }
}
 */