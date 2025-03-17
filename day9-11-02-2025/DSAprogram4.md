# Military Camp Boundary Calculator

## Problem Description

The Indian Army has established multiple military camps at strategic locations along the Line of Actual Control (LAC) in Galwan. These camps are connected in a hierarchical structure, with a main base camp acting as the root of the network.

Your task is to determine the list of military camp IDs forming the outer boundary of the military network. This boundary must be traversed in anti-clockwise order, starting from the main base camp (root).

### Input Format
- Space-separated integers, `military-camp IDs`.

### Output Format
- Print all the military-camp IDs, which are at the edge of the S.H.I.E.L.D.

### Sample Input-1
```
5 2 4 7 9 8 1
```

### Sample Output-1
```
[5, 2, 7, 9, 8, 1, 4]
```

### Sample Input-2
```
11 2 13 4 25 6 -1 -1 -1 7 18 9 10
```

### Sample Output-2
```
[11, 2, 4, 7, 18, 9, 10, 6, 13]
```

### Sample Input-3
```
1 2 3 -1 -1 -1 5 -1 6 7
```

### Sample Output-3
```
[1, 2, 7, 6, 5, 3]
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

public class Program4 {
    private static List<Integer> sol(int[] arr) {
        TreeNode root = buildTree(arr);
        List<Integer> l = new ArrayList<>();

        l.add(root.val);
        leftPart(root.left, l);
        leafs(root, l);
        rightPart(root.right, l);

        return l;
    }

    private static void leftPart(TreeNode root, List<Integer> l) {
        if (root == null) return;

        if (!l.contains(root.val)) l.add(root.val);
        if (root.left == null) leftPart(root.right, l);
        leftPart(root.left, l);
    }

    private static void rightPart(TreeNode root, List<Integer> l) {
        if (root == null) return;

        if (root.right == null) rightPart(root.left, l);
        rightPart(root.right, l);
        if (!l.contains(root.val)) l.add(root.val);
    }

    private static void leafs(TreeNode root, List<Integer> l) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (!l.contains(root.val)) l.add(root.val);
        }
        leafs(root.left, l);
        leafs(root.right, l);
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