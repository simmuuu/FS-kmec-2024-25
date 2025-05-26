/*
Indus Infra Ltd purchased a land of size L * W acres, for their upcoming venture.
The land is divided into rectangular plots, using fences. They have kept some 
H horizontal fences as hfences[] and V vertical fences as vfences[] on the land,
where hfence[i] is the distance from the top of the land to the i-th horizontal
fence and, vfence[j] is the distance from the top of the land to the j-th 
vertical fence. Each 1*1 cell is one acre plot.

Mr.RGV wants to purchase the biggest plot available to build a Guest-house.
Your task is to help Mr.RGV to find the biggest plot vailable after the fences 
are setup in the venture.
NOTE: The answer can be a large number, return the modulo of 10^9 + 7.

Input Format:
-------------
Line-1: 4 space separated integers, L,W,H and V
Line-2: H space separated integers, hfence[] in the range [0, L]
Line-3: V space sepaarted integers, vfence[] in the range [0, W]

Output Format:
--------------
Print an integer result, the area of biggest plot.


Sample Input-1:
---------------
5 6 2 2
2 3
2 5

Sample Output-1:
----------------
6


Sample Input-2:
---------------
5 6 1 1
3
4

Sample Output-2:
----------------
12
*/

import java.util.*;

public class DSAprogram2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        int V = sc.nextInt();

        int[] hfences = new int[H];
        for (int i = 0; i < H; i++) {
            hfences[i] = sc.nextInt();
        }

        int[] vfences = new int[V];
        for (int i = 0; i < V; i++) {
            vfences[i] = sc.nextInt();
        }

        int maxH = maxDist(hfences, L);
        int maxW = maxDist(vfences, W);

        System.out.println((int) (((long)maxH * maxW) % 1_000_000_007));
    }

    public static int maxDist(int[] fences, int end) {
        Arrays.sort(fences);
        int maxDist = fences[0]; // first fence from left/top
        for(int i = 1; i < fences.length; i++) {
            // dist between two horizontal or vertical fences
            maxDist = Math.max(maxDist, fences[i] - fences[i - 1]); 
        }
        // dist between last fence and right/bottom
        maxDist = Math.max(maxDist, end - fences[fences.length - 1]);

        return maxDist;
    }
}