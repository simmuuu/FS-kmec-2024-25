/*
------ EVENT BRITE ASKS BACKTRACKING ------

Bablu is working in a construction field.
He has N number of building blocks, where the height and width of all the blocks are same.
And the length of each block is given in an array, blocks[].

Bablu is planned to build a wall in the form of a square.
The rules to cunstruct the wall are as follows:
	- He should use all the building blocks.
	- He should not break any building block, but you can attach them with other.
	- Each building-block must be used only once.

Your task is to check whether Bablu can cunstruct the wall as a square
with the given rules or not. If possible, print true. Otherwise, print false.

Input Format:
-------------
Line-1: An integer N, number of BuildingBlocks.
Line-2: N space separated integers, length of each block.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
6
1 2 6 4 5 6

Sample Output-1:
----------------
true


Sample Input-2:
---------------
6
5 3 2 5 5 6

Sample Output-2:
----------------
false
*/

import java.util.*;

public class DSAprogram1 {

    public static boolean sol(int[] inp) {
        int sum = 0;
        for (int i : inp) sum += i;

        // if perimiter cant be divded into 4 sides, return false
        if (sum % 4 != 0) return false;

        // perimeter = 4 * side
        int target = sum / 4;

        Arrays.sort(inp);

        // reverse the array for backtracking to fail first
        int l = 0, r = inp.length - 1;
        while (l < r) {
            int temp = inp[l];
            inp[l] = inp[r];
            inp[r] = temp;
            l++;
            r--;
        }

        int[] sides = new int[4];

        return backtrack(sides, 0, inp, target);
    }

    private static boolean backtrack(
        int[] sides,
        int index,
        int[] inp,
        int target
    ) {
        // base case: if inp array is completely processed, check if sides array is valid
        if (index == inp.length) {
            return (
                sides[0] == target &&
                sides[1] == target &&
                sides[2] == target &&
                sides[3] == target
            );
        }

        // placing block on each side
        for (int i = 0; i < 4; i++) {
            if (sides[i] + inp[index] <= target) {
                sides[i] += inp[index];

                if (backtrack(sides, index + 1, inp, target)) return true;

                // it didn't workout. backtrack. remove this block
                sides[i] -= inp[index];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] inp = new int[n];
        for (int i = 0; i < n; i++) {
            inp[i] = sc.nextInt();
        }

        System.out.println(sol(inp));

        sc.close();
    }
}
