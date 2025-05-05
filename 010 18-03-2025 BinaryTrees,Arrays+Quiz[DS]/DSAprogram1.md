# Decision Tree Flipper

## Problem Description

VishnuVardan is working with Decision Trees for AI-based predictions. To analyze alternative outcomes, Kishore has planned to flip the decision tree horizontally to simulate a reverse processing approach.

### Rules for Flipping the Decision Tree:
- The original root node becomes the new rightmost node.
- The original left child becomes the new root node.
- The original right child becomes the new left child.

This transformation is applied level by level recursively.

### Input Format
- Space-separated integers, nodes of the tree.

### Output Format
- Print the list of nodes of the flipped tree.

### Sample Input-1
```
4 2 3 5 1
```

### Sample Output-1
```
5 1 2 3 4
```

### Sample Input-2
```
4 2 5
```

### Sample Output-2
```
2 5 4
```

## Solution

```java
import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class DSAprogram1 {
    public static void sol(int[] inp) {
        Node root = buildTree(inp);
        
        root = flipTree(root);
        levelOrder(root);
    }

    private static Node flipTree(Node root) {
        if(root == null || root.left == null) return root;
        
        Node newnode = flipTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return newnode;
    }

    private static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node node = q.poll();

            System.out.print(node.val + " ");
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
    }

    private static Node buildTree(int[] arr) {
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;
        while(!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            if(i < arr.length && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;
        
            if(i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sol(inp);

        sc.close();
    }
}
```