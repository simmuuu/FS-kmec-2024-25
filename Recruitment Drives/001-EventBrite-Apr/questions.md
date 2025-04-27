## Question 2

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
class program2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int from[]=new int[n-1];
        int to[]=new int[n-1];
        int val[]=new int[n-1];
        for(int i=0;i<n-1;i++){
            from[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++){
            to[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++){
            val[i]=sc.nextInt();
        }
        int value = sc.nextInt();
        sc.close();
        Map<Integer,List<int[]>> m=new HashMap<>();
        for(int i=0;i<n-1;i++){
            m.computeIfAbsent(from[i],k->new ArrayList<>()).add(new int[]{to[i],val[i]});
            m.computeIfAbsent(to[i],k->new ArrayList<>()).add(new int[]{from[i],val[i]});
        }
        int ans[]=new int[n];
        int k=0;
        for(int key:m.keySet()){
            int a[]=new int[1];
            dfs(key,m,new boolean[n],a,0,value);
            ans[k++]=a[0];
        }
        System.out.println(Arrays.toString(ans));
    }
    public static void dfs(int key,Map<Integer,List<int[]>> m,boolean b[],int[] a,int sum,int val){
        if(b[key-1]) return;
        b[key-1]=true;
        if(sum!=0 && sum%val==0) a[0]++;
        for(int i[]:m.get(key)){
            dfs(i[0],m,b,a,sum+i[1],val);
        }
    }
}
