/*
MotorSport Ltd hosting a Racing Championship. 
Ajith is participating in car races. Each race start and end in perticular time intervals.

You are given an array of racing time intervals consisting of
start and end times [[s1,e1],[s2,e2],...] (s < e ) of N races, in which Ajith has to participate.
Your task is to determine whether Ajith can participate in all the races or not.

NOTE: If a race starts at time 'a' ends at time 'b', 
another race can start at 'b'.

Input Format:
-------------
Line-1: An integer N, number of races Ajith has to participate.
Next N lines: Two space separated integers, start and end time of each race.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
3
0 30
5 10
15 20

Sample Output-1:
----------------
false

Sample Input-2:
---------------
3
0 10
15 25
30 35

Sample Output-2:
----------------
true

*/

import java.util.*;

public class DSAprogram1 {
    public static boolean sol(int[][] inp) {
        Arrays.sort(inp, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < inp.length - 1; i++) {
            if(inp[i][1] > inp[i + 1][0]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] inp = new int[n][2];

        for(int i = 0; i < n; i++) {
            inp[i][0] = sc.nextInt();
            inp[i][1] = sc.nextInt();
        }

        System.out.println(sol(inp));
    }
}