/*
Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
An integer I

Output Format:
--------------
Print the BBC representation of I.


Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000


Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110
*/

import java.util.*;
class program1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        String s=Integer.toBinaryString(n);
        StringBuilder sb=new StringBuilder(s);
        int j=sb.length()-1;
        while(j>=0){
            if(sb.charAt(j)=='0'){
                sb.setCharAt(j,'1');
                break;
            }
            sb.setCharAt(j,'0');
            j--;
        }
        if(sb.charAt(0)=='1') sb.deleteCharAt(0);
        System.out.println(sb.toString());
    }
}