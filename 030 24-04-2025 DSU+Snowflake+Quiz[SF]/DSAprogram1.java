
/*
There are N computers in a network, all the computers are connected as tree
structure. And one new connection is added in the Network. The computers in
the network are identified with their IDs, the IDs are numbered between 1 to N.

The connections in the network is given as coonection[i] = [comp-A, comp-B],
there is a connection between comp-A and comp-B.

Your task is to remove a connection in the network and print it, so that
all the computers are connected as tree structure. If there are multiple
options to remove, remove the connection that occurs last in the input.


Input Format:
-------------
Line-1: Two space separated integers N, number of computers.
Next N lines: Two space separated integers, comp-A & comp-B.

Output Format:
--------------
Print the connection which is removed.


Sample Input-1:
---------------
6
1 2
3 4
3 6
4 5
5 6
2 3

Sample Output-1:
---------------
5 6


Sample Input-2:
---------------
4
1 2
2 3
3 4
2 4

Sample Output-2:
---------------
2 4 */

import java.util.*;
class DSAprogram1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] edges = new int[n][2];
        for(int i = 0; i < n; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        parent = new int[n+1];
        for(int i = 0 ;i < n+1; i++){
            parent[i] = i;
        }

        int [] result = new int[2];
        for(int[] edge : edges){
            if(!union(edge[0], edge[1])){
                result = edge;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
    static int [] parent;
    public static boolean union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);
        if(p1 == p2){
            return false;
        }
        parent[p2] = p1;
        return true;
    }
    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
