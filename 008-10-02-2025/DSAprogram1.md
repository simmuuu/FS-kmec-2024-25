# Self-Mirror Binary Tree Checker

## Problem Description

Mr. Rakesh is interested in working with data structures and has constructed a binary tree (BT). He has asked his friend Anil to check whether the BT is a self-mirror tree. A self-mirror tree is a binary tree where the left subtree is a mirror reflection of the right subtree.

### Input Format
- A single line of space-separated integers representing the values at the tree nodes. `-1` indicates an empty (null) node.

### Output Format
- Print a boolean value: `true` if the tree is a self-mirror tree, otherwise `false`.

### Sample Input-1
```
2 1 1 2 3 3 2
```

### Sample Output-1
```
true
```

### Sample Input-2
```
2 1 1 -1 3 -1 3
```

### Sample Output-2
```
false
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

public class program1 {
    public static boolean sol(int[] arr) {
        TreeNode root = buildTree(arr);

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return (left.val == right.val) && isMirror(left.left, right.right) &&
                                            isMirror(left.right, right.left);
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

        System.out.println(sol(inp));

        sc.close();
    }
}
```