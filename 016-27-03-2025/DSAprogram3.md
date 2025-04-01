# Count Pages with Sum Equal to Descendants  

## Problem Description  

There are some pages on a website, each linking to at most two other pages. Each page displays a number. The website is structured as a **binary tree**, where each node represents a page, and numbers are assigned using **level-order insertion**.  

Your task is to find the **number of pages** where the number displayed is equal to the sum of the numbers of its descendants.  

A **descendant** is any page linked but lower in the tree, no matter how many levels down.  

## Input Format  
- A **single line** of **comma-separated integers**, representing the numbers displayed on the web pages in level order.  

## Output Format  
- Print a **single integer**, the count of such pages.  

## Sample Input 1  
```
11 3 5 2 1
```

## Sample Output 1  
```
2
```

## Sample Input 2  
```
3 2 1 0 0
```

## Sample Output 2  
```
3
```

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

class Helper {
    int count, sum;

    Helper(int count, int sum) {
        this.count = count;
        this.sum = sum;
    }
}

public class DSAprogram3 {
    public static int sol(int[] arr) {
        TreeNode root = buildTree(arr);
        return countPages(root).count;
    }

    private static Helper countPages(TreeNode root) {
        if(root == null) return new Helper(0, 0);

        Helper left = countPages(root.left);
        Helper right = countPages(root.right);

        int count = left.count + right.count;
        if(left.sum + right.sum == root.val) count++;

        return new Helper(count, root.val + left.sum + right.sum);
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