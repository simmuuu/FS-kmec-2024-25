# Library Organization

## Problem Description

Imagine you are a librarian organizing books on vertical shelves in a grand library. The books are currently scattered across a tree-like structure, where each book (node) has a position determined by its shelf number (column) and row number (level).

Your task is to arrange the books on shelves so that:
1. Books are placed column by column from left to right.
2. Within the same column, books are arranged from top to bottom (i.e., by row).
3. If multiple books belong to the same shelf and row, they should be arranged from left to right, just as they appear in the original scattered arrangement.

Given a binary tree, return the list of lists, where each list contains the books (nodes) in each shelf, organized as described.

## Input Format
- A binary tree is represented as a list of integers, where `-1` represents an empty node.

## Output Format
- A 2D list, where each inner list contains the nodes of the tree arranged as described above.

## Constraints
- The binary tree has a maximum of $10^5$ nodes.
- The tree is a binary tree, so each node has at most two children.

## Sample Input 1  
```
3 9 20 -1 -1 15 7
```

## Sample Output 1  
```
[[9], [3, 15], [20], [7]]
```

### Explanation  
The tree structure is as follows:
```
         3
       /   \
      9     20
          /    \
         15     7
```
Shelf 1: [9]  
Shelf 2: [3, 15]  
Shelf 3: [20]  
Shelf 4: [7]

## Sample Input 2  
```
3 9 8 4 0 1 7
```

## Sample Output 2  
```
[[4], [9], [3, 0, 1], [8], [7]]
```

### Explanation  
The tree structure is as follows:
```
          3  
        /   \
       /     \
      9       8
    /   \   /   \
   4     0 1     7
```
Shelf 1: [4]  
Shelf 2: [9]  
Shelf 3: [3, 0, 1]  
Shelf 4: [8]  
Shelf 5: [7]

## Solution Code  

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

class NodeInfo {
    int row, col, val;

    public NodeInfo(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class DSAProgram1 {
    public static List<List<Integer>> sol(int[] arr) {
        TreeNode root = buildTree(arr);
        List<NodeInfo> l = new ArrayList<>();
        dfs(root, l, 0, 0);

        Collections.sort(l, (a, b) -> {
            if(a.col != b.col) return a.col - b.col;
            else return a.row - b.row;
        });

        List<List<Integer>> res = new ArrayList<>();
        int currCol = Integer.MIN_VALUE;
        for(NodeInfo node: l) {
            if(node.col > currCol) {
                currCol = node.col;
                res.add(new ArrayList<>());
            }
            res.get(res.size() - 1).add(node.val);
        }

        return res;
    }

    private void dfs(TreeNode root, List<NodeInfo> l, int row, int col) {
        if(root == null) return;

        l.add(new NodeInfo(row, col, root.val));

        dfs(root.left, l, row + 1, col - 1);
        dfs(root.right, l, row + 1, col + 1);
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