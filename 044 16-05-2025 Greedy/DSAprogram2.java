/*
There are N employees from 3 different companies in a row, emps[], the employees 
are identified using company IDs as 1,2,3. A Courier Boy need to deliver 
P parcels to these 3 companies. The parcel details are given as parcels[],
where parcel[i]=[Ci,CIDi], i-th parcel, 'Ci' is Courier Boy's current position, 
and  'CIDi' is company's ID, he/she need to deliver parcel[i] from Ci position 
to the nearest employee belongs to companay ID equals to CIDi in the row.

You are given emps[] and parcels[] information,
Your task is to help the courier boy to find the distance between him to 
the nearest employee in that row to deliver the parcel.
If there is no solution found, return -1.

Input Format:
-------------
Line-1: Two space separated integers, N and P
Line-2: N space separated integers, only 1, 2 & 3.
Next P lines: Two space separated integers, position Ci and Company ID

Output Format:
--------------
Print the space separated integers, distance between boy and the employee for 
all the parcels.


Sample Input-1:
---------------
6 2
1 1 2 2 3 3
1 3
2 2

Sample Output-1:
----------------
3 0 

Sample Input-2:
---------------
5 2
1 2 3 2 1
2 1
1 1

Sample Output-2:
----------------
2 1 


*/

import java.util.*;

public class DSAprogram2 {
    private static void sol(int[] emp, int[][] parcels) {
        Map<Integer, List<Integer>> emphMap = new HashMap<>();

        for(int i = 0; i < emp.length; i++) {
            emphMap.computeIfAbsent(emp[i], k -> new ArrayList<>()).add(i);
        }

        for(int i = 0; i < parcels.length; i++) {
            int posi = parcels[i][0];
            int Cid = parcels[i][1];

            if(!emphMap.containsKey(Cid)) {
                System.out.print("-1 ");
                continue;
            }

            int min = Integer.MAX_VALUE;
            for(int posCi: emphMap.get(Cid)) {
                min = Math.min(min, Math.abs(posCi - posi));
            }

            System.out.print(min + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();
        sc.nextLine();

        int[] emp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] parcels = new int[p][2];

        for(int i = 0; i < p; i++) {
            parcels[i][0] = sc.nextInt();
            parcels[i][1] = sc.nextInt();
        }

        sol(emp, parcels);
    }
}