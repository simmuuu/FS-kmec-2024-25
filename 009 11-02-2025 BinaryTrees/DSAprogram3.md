# Left-Most Sensor Identifier in a Binary Tree

## Problem Description

A software development company is designing a smart home automation system that uses sensor networks to monitor and control different devices in a house. The sensors are organized in a hierarchical structure, where each sensor node has a unique ID and can have up to two child nodes (left and right). The company wants to analyze the left-most sensors in the system to determine which ones are critical for detecting environmental changes. The hierarchy of the sensors is provided as a level-order input, where missing sensors are represented as `-1`.

### Input Format
- Space-separated integers representing the elements of the tree. `-1` indicates an empty (null) position.

### Output Format
- A list of integers representing the left-most sensor IDs at each level.

### Sample Input-1
```
1 2 3 4 -1 -1 5
```

### Sample Output-1
```
[1, 2, 4]
```

### Sample Input-2
```
3 2 4 1 5
```

### Sample Output-2
```
[3, 2, 1]
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
    private static List<Integer> sol(int[] arr) {
        if (arr.length == 0) return new ArrayList<>();

        TreeNode root = buildTree(arr);

        Map<Integer, Integer> tmap = new TreeMap<>();
        leftMost(root, 0, tmap);

        return new ArrayList<>(tmap.values());
    }

    private static void leftMost(TreeNode root, int depth, Map<Integer, Integer> tmap) {
        if (root == null) return;

        tmap.putIfAbsent(depth, root.val);
        leftMost(root.left, depth + 1, tmap);
        leftMost(root.right, depth + 1, tmap);
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