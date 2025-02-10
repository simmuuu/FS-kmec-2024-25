/*
A security team is setting up surveillance cameras in a multi-floor building. 
Each floor has a certain number of cameras, and every camera is assigned 
a resolution value (in megapixels). The placement follows a hierarchical 
structure, similar to a tree:
	- Floor 0 (Ground Floor) has a single main camera (root camera).
	- From the next floor onward, each camera can have at most two sub-cameras, 
	one on the left side and one on the right side.
	- If a camera does not have a sub-camera at a position, it is represented as -1.
	
The goal is to identify the camera with the highest resolution on each floor to 
ensure optimal security coverage.

Input Format:
-------------
A single line of space separated integers, the resolution values of cameras

Output Format:
--------------
A list of integers, where eech integer represents the maximum resolution camera 
on that floor.


Sample Input-1:
---------------
2 4 3 6 4 -1 9

Sample Output-1:
----------------
[2, 4, 9]


Sample Input-2:
---------------
3 4 7 7 3 8 4 

Sample Output-2:
----------------
[3, 4, 8]

*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class program4 {
    public static List<Integer> sol(int[] arr) {
        TreeNode root = buildTree(arr);
		
		List<Integer> l = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()) {
			int size = q.size();

			int levelMax = -1;
			for(int i = 0; i < size; i++) {
				TreeNode curr = q.poll();

				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);

				levelMax = Math.max(curr.val, levelMax);
			}

			l.add(levelMax);
		}

		return l;
    }

    private static TreeNode buildTree(int[] arr) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q.add(root);

        int i = 1;
        while(!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if(i < arr.length && arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;

            if(i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sol(inp));

        sc.close();
    }
}