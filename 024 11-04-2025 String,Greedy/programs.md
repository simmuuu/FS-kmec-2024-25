/*
Rohan has a habit of writing a word in reverse as R and then checks whether R is same as Original word W. 
If R is not the same as W, he can remove only one character from R to make it as W.
Print 'true', if Rohan makes R equals W, Otherwise print 'false'.

Input Format:
-------------
Line-1: A string representing a word.

Output Format:
--------------
Return a boolean result.

Sample Input-1:
---------------
bcba

Sample Output-1:
----------------
true

Explanation:
------------
By removing character 'a', the word in reverse will also become the same.

Sample Input-2:
---------------
abcd

Sample Output-2:
----------------
false

Explanation:
-------------
There is no possibility to make the reverse equal to the original word.
*/

import java.util.*;

class Program1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        sc.close();
        int i = 0, j = s1.length() - 1, c = 0;
        boolean reverse = true;

        while (i <= j) {
            if (s1.charAt(i) == s1.charAt(j)) {
                i++;
                j--;
            } else {
                if (s1.charAt(i + 1) == s1.charAt(j) && c == 0) {
                    i++;
                    c = 1;
                } else if (s1.charAt(j - 1) == s1.charAt(i) && c == 0) {
                    j--;
                    c = 1;
                } else {
                    reverse = false;
                    break;
                }
            }
        }
        System.out.print(reverse);
    }
}

/*
A number is called self-supportive if all the digits of the number are factors of the number. 
For example, 48 is a self-supportive number because 48 % 4 == 0, and 48 % 8 == 0.

A number is not self-supportive if it has any digit as zero.

Given two positive numbers start and end, return a set of all the self-supportive numbers in between start and end (both inclusive).

1 <= start <= end <= 10^4

Input Format:
-------------
Line: 2 space-separated integers start and end.

Output Format:
--------------
Print a space-separated list.

Sample Input-1:
---------------
20 25

Sample Output-1:
----------------
22 24

Explanation:
-----------
20 has 0 as a digit, so it's not self-supportive.
21 is not divisible by 2, so it's not self-supportive.
22 is divisible by 2, so it's self-supportive.
23 is not divisible by both the digits 2 and 3, so it's not self-supportive.
24 is divisible by both 2 and 4, so it is self-supportive.
Thus, 22 and 24 are self-supportive.

Sample Input-2:
---------------
50 80

Sample Output-2:
----------------
55 66 77
*/

import java.util.*;

class Program2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int st = sc.nextInt();
        int end = sc.nextInt();
        sc.close();
        List<Integer> l = new ArrayList<>();
        
        while (st <= end) {
            if (selfProtective(st)) {
                l.add(st);
            }
            st++;
        }
        System.out.println(l);
    }

    public static boolean selfProtective(int num) {
        int n = num;
        while (n != 0) {
            int rem = n % 10;
            if (rem == 0 || num % rem != 0) return false;
            n /= 10;
        }
        return true;
    }
}

/*
Chhota Bheem is fond of Laddus. There are N Laddus in a row, N is an even number. 
Where the k-th laddu is of type laddu[k], 1 <= k <= N.

Due to health issues, Chhota Bheem was suggested to eat at most N/2 Laddus of different types. 
He can eat only 1 Laddu of each type.

You are given a list of integers. Your task is to find the maximum number of Laddus Chhota Bheem can eat.

Input Format:
-------------
Line-1: An integer N, representing the number of Laddus.
Line-2: N space-separated integers, Laddu types.

Output Format:
--------------
Print an integer result.

Sample Input-1:
---------------
6
2 4 1 2 3 4

Sample Output-1:
----------------
3

Explanation:
------------
There are 6 Laddus, and 4 types of Laddus.
So Bheem can eat 3 laddus only.

Sample Input-2:
---------------
8
1 1 1 2 1 2 1 1

Sample Output-2:
----------------
2

Explanation:
------------
There are 8 Laddus, and 2 types of Laddus.
So Bheem can eat 2 laddus only.
*/

import java.util.*;

class Program3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> st = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            st.add(sc.nextInt());
        }
        
        int half = n / 2;
        System.out.println(st.size() >= half ? half : st.size());
    }
}

/*
Two brothers want to play a game.
The rules of the game are: one player gives two sorted lists of numerical elements and a number (sum). 
The opponent has to find the closest pair of elements to the given sum.
-> Pair consists of elements from each list.

Please help those brothers to develop a program that takes two sorted lists as input and returns a pair as output.

Input Format:
-------------
Size of list_1
List_1 values
Size of list_2
List_2 values
Closest number

Output Format:
--------------
Comma-separated pair.

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32

Sample Output-1:
---------------
1,30

Sample Input-2:
---------------
3
2 4 6
4
5 7 11 13
15

Sample Output-2:
---------------
2,13
*/

import java.util.*;

class Program4 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a[] = new int[n1];
        for (int i = 0; i < n1; i++) a[i] = sc.nextInt();
        
        int n2 = sc.nextInt();
        int b[] = new int[n2];
        for (int i = 0; i < n2; i++) b[i] = sc.nextInt();
        
        int closet_sum = sc.nextInt();
        int diff = Integer.MAX_VALUE;
        int ans[] = new int[2];
        int i = 0, j = n2 - 1;
        
        while (i < n1 && j >= 0) {
            int sum = a[i] + b[j];
            if (Math.abs(closet_sum - sum) < diff) {
                ans[0] = a[i];
                ans[1] = b[j];
                diff = Math.abs(closet_sum - sum);
                j--;
            } else {
                i++;
            }
        }
        System.out.print(ans[0] + "," + ans[1]);
    }
}

/*
Govind is playing with strings.
He is given two strings S1 and S2. He has to find if each character in S1 can match a word in S2 uniquely or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e., a function that relates each letter in string S1 to a separate and distinct non-empty word in S2,
where each non-empty word in S2 also has a corresponding letter in S1.

Return true if S1 can match S2 completely. Otherwise, return false.

Note: You may assume S1 and S2 contain only lowercase letters, and S2 contains whitespace as well.

Input Format:
-------------
Line-1 -> A string S1 (a single word).
Line-2 -> A string S2 (group of space-separated words).

Output Format:
--------------
Print a boolean value.

Sample Input-1:
---------------
baba
cat rat cat rat

Sample Output-1:
----------------
true

Sample Input-2:
---------------
baba
cat rat rat cat

Sample Output-2:
----------------
false
*/

import java.util.*;

class Program5 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1[] = sc.nextLine().split(" ");
        sc.close();
        
        if (s.length() != s1.length) {
            System.out.println(false);
            return;
        }
        
        boolean b = true;
        Map<Character, String> m = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String word = s1[i];
            
            if (m.containsKey(c)) {
                if (!m.get(c).equals(word)) {
                    b = false;
                    break;
                }
            } else {
                if (m.containsValue(word)) {
                    b = false;
                    break;
                }
                m.put(c, word);
            }
        }
        System.out.println(b);
    }
}
