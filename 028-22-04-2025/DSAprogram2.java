/*
The government has set up a network of smart traffic lights connected
by roads, forming a tree structure with n traffic lights. Each road has a
communication delay measured in meters.

Each road connects exactly two traffic lights, and all lights are connected
(i.e., there are no cycles).

To maintain secure and efficient signal relays, the system allows only indirect
communication — where two traffic lights can communicate via a third traffic
light (called the mediator) if:

The total signal path length (distance from light A to mediator to light B) is
divisible by a given signal propagation speed.

You are to compute, for each traffic light, the number of such valid (A → B)
communication pairs that it can mediate.

Input Format:
-------------
Line-1: An integer N     // number of traffic lights
Line-2: N-1 space sepearted integers,  light_from[].
Line-3: N-1 space sepearted integers,  light_to[].
Line-4: N-1 space sepearted integers,  road_lengths[].
Line-5: An integer, signal_speed    // signal propagation speed

Output Format:
---------------
An array of size n, where the ith value is the number of valid pairs
that use traffic light i+1 as a mediator


Sample Input:
-------------
4
1 1 2
2 3 4
2 5 3
5

Sample Output:
--------------
2 0 2 2
*/


import java.util.*;

public class DSAprogram2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] from = new int[n-1];
        int[] to = new int[n-1];
        int[] val = new int[n-1];
        
        for(int i = 0; i < n-1; i++) {
            from[i] = sc.nextInt();
        } 
        for(int i = 0; i < n-1; i++) {
            to[i] = sc.nextInt();
        }
        for(int i = 0; i < n-1; i++) {
            val[i] = sc.nextInt();
        }

        int signalSpeed = sc.nextInt();
        
        System.out.println(Arrays.toString(sol(n, from, to, val, signalSpeed)));
    }
    
    public static int[] sol(int n, int[] from, int[] to, int[] val, int signalSpeed) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 0; i < n-1; i++) {
            graph.computeIfAbsent(from[i], k -> new ArrayList<>()).add(new int[]{to[i], val[i]});
            graph.computeIfAbsent(to[i], k -> new ArrayList<>()).add(new int[]{from[i], val[i]});
        }
        
        int[] answer = new int[n];
        int index = 0;
        
        for(int key : graph.keySet()) {
            int[] count = new int[1];
            dfs(key, graph, new boolean[n+1], count, 0, signalSpeed);
            answer[index++] = count[0];
        }
        
        return answer;
    }
    
    public static void dfs(int node, Map<Integer, List<int[]>> graph, boolean[] visited, int[] count, int distance, int signalSpeed) {
        visited[node] = true;
        
        if(distance != 0 && distance % signalSpeed == 0) {
            count[0]++;
        }
        
        for(int[] neighbor : graph.get(node)) {
            int nextNode = neighbor[0];
            int dist = neighbor[1];
            
            if(!visited[nextNode]) {
                dfs(nextNode, graph, visited, count, distance + dist, signalSpeed);
            }
        }
    }
}