# Binary Tree Construction from Level-Order Input

## Problem Description

Write a program to construct a binary tree from level-order input, treating `-1` as a placeholder for missing nodes. The program reads input, constructs the tree, and provides an in-order traversal to verify correctness.

### Input Format
- Space-separated integers, level-order data (where `-1` indicates a null node).

### Output Format
- Print the in-order traversal of the tree.

### Sample Input-1
```
1 2 3 -1 -1 4 5
```

### Sample Output-1
```
2 1 4 3 5
```

### Explanation-1
The tree looks like this:
```
    1
   / \
  2   3
     / \
    4   5
```

### Sample Input-2
```
1 2 3 4 5 6 7
```

### Sample Output-2
```
4 2 5 1 6 3 7
```

### Explanation-2
The tree looks like this:
```
        1
       / \
      2   3
     / \  / \
    4   5 6  7
```

## Solution

```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class program1 {
    public static void sol(int n, int[] inp) {
        if (n == 0 || inp[0] == -1) {
            return;
        }

        TreeNode root = new TreeNode(inp[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < n) {
            TreeNode curr = q.poll();

            if (i < n && inp[i] != -1) {
                curr.left = new TreeNode(inp[i]);
                q.add(curr.left);
            }
            i++;

            if (i < n && inp[i] != -1) {
                curr.right = new TreeNode(inp[i]);
                q.add(curr.right);
            }
            i++;
        }

        printInOrder(root);
    }

    private static void printInOrder(TreeNode root) {
        if (root == null) return;

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inp = sc.nextLine().split(" ");
        int[] data = new int[inp.length];

        for (int i = 0; i < inp.length; i++) {
            data[i] = Integer.valueOf(inp[i]);
        }

        sol(data.length, data);

        sc.close();
    }
}
```