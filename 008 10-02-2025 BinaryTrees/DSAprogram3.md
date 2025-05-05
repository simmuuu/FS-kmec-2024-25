# Second Highest Clearance Level Finder

## Problem Description

In an Intelligence Agency, each senior officer supervises either two junior officers or none. The senior officer is assigned a clearance level equal to the higher clearance level of the two junior officers they supervise. The clearance levels are represented as integer values in the range [1, 50], and multiple officers may have the same clearance level.

Your task is to find the second highest clearance level among all agents in the agency. If no such level exists, return `-2`.

### Input Format
- A single line of space-separated integers representing the clearance levels of each individual. `-1` indicates an empty (null) position.

### Output Format
- Print an integer, the second highest clearance level.

### Sample Input-1
```
5 5 4 -1 -1 2 4
```

### Sample Output-1
```
4
```

### Sample Input-2
```
3 3 3 3 3
```

### Sample Output-2
```
-2
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

public class program3 {
    public static int sol(int[] arr) {
        if (arr.length == 0) return -2;

        TreeNode root = buildTree(arr);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int max1 = -2, max2 = -2;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.val > max1) {
                max2 = max1;
                max1 = curr.val;
            } else if (curr.val > max2 && curr.val != max1) {
                max2 = curr.val;
            }

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }

        return max2;
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