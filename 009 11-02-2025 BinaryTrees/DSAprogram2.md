# Right Side View of a Binary Tree

## Problem Description

Balbir Singh is working with binary trees and is interested in determining the nodes visible from the right side of the tree when viewed from top to bottom. The elements of the tree are given in level-order format.

### Input Format
- Space-separated integers representing the elements of the tree. `-1` indicates an empty (null) position.

### Output Format
- A list of integers representing the node values visible from the right side of the tree.

### Sample Input-1
```
1 2 3 4 -1 -1 5
```

### Sample Output-1
```
[1, 3, 5]
```

### Sample Input-2
```
3 1 4 5 2
```

### Sample Output-2
```
[3, 4, 2]
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

public class program2 {
    private static List<Integer> sol(int[] arr) {
        if (arr.length == 0) return new ArrayList<>();

        TreeNode root = buildTree(arr);

        Map<Integer, Integer> tmap = new TreeMap<>();
        rightMost(root, 0, tmap);

        return new ArrayList<>(tmap.values());
    }

    private static void rightMost(TreeNode root, int depth, Map<Integer, Integer> tmap) {
        if (root == null) return;

        tmap.putIfAbsent(depth, root.val);
        rightMost(root.right, depth + 1, tmap);
        rightMost(root.left, depth + 1, tmap);
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