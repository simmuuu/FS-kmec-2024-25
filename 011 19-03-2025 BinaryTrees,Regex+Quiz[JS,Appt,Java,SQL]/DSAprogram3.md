# Shortest Distance Between Two Nodes in a Binary Tree

## Problem Description
Given a binary tree and two distinct node values, determine the shortest distance between them. The distance between two nodes is defined as the number of edges along the shortest path connecting them.

### Input Format
- A single line of space-separated integers representing the values at the tree nodes.
- `-1` indicates an empty (null) node.
- Two integers `n1` and `n2`, representing the nodes for which the shortest distance needs to be calculated.

### Output Format
- An integer representing the shortest distance between `n1` and `n2`.

### Sample Input-1
```text
1 2 3 4 5 6 7
4 5
```

### Sample Output-1
```text
2
```

### Sample Input-2
```text
1 2 3 -1 4 -1 5
4 5
```

### Sample Output-2
```text
3
```

## Solution
```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class DSAprogram3 {
    public static int sol(int[] arr, int n1, int n2) {
        if(n1 == n2) return 0;

        TreeNode root = buildTree(arr);

        TreeNode l = findLCA(root, n1, n2);
        int d1 = findDist(l, n1, 0);
        int d2 = findDist(l, n2, 0);

        return d1 + d2;
    }

    private static int findDist(TreeNode root, int target, int distance) {
        if(root == null) return -1;

        if(root.val == target) return distance;

        int leftDist = findDist(root.left, target, distance + 1);
        if(leftDist != -1) return leftDist;

        int rightDist = findDist(root.right, target, distance + 1);
        return rightDist;
    }

    private static TreeNode findLCA(TreeNode root, int n1, int n2) {
        if(root == null) return null;

        if(root.val == n1 || root.val == n2) return root;

        TreeNode leftLCA = findLCA(root.left, n1, n2);
        TreeNode rightLCA = findLCA(root.right, n1, n2);

        if(leftLCA != null && rightLCA != null) return root;
        
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    private static TreeNode buildTree(int[] arr) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if (i < arr.length && arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
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
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println(sol(inp, n1, n2));

        sc.close();
    }
}
```

