/*
You are developing an application for a garden management system where each tree 
in the garden is represented as a binary tree structure. The system needs to 
allow users to plant new trees in a systematic way, ensuring that each tree is 
filled level by level.

A gardener wants to:
 - Plant trees based on user input.
 - Ensure trees grow in a balanced way by filling nodes level by level.
 - Inspect the garden layout by performing an in-order traversal, which helps 
   analyze the natural arrangement of trees.

Your task is to implement a program that:
    - Accepts a list of N tree species (as integers).
    - Builds a binary tree using level-order insertion.
    - Displays the in-order traversal of the tree.

Input Format:
-------------
- An integer N representing the number of tree plants.
- A space-separated list of N integers representing tree species.

Output Format:
--------------
A list of integers, in-order traversal of tree.


Sample Input:
-------------
7
1 2 3 4 5 6 7

Sample Output:
--------------
4 2 5 1 6 3 7


Explanation:
------------
The tree looks like this:

        1
       / \
      2   3
     / \  / \
    4   5 6  7
The in order is : 4 2 5 1 6 3 7 
*/

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class program4 {
    public static void sol(int n, int[] inp) {
        Node root = new Node(inp[0]);

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        // build tree in-order
        while(!q.isEmpty() && i < n) {
            Node current = q.poll();

            if(i < n) {
                current.left = new Node(inp[i++]);
                q.offer(current.left);
            }

            if(i < n) {
                current.right = new Node(inp[i++]);
                q.offer(current.right);
            }
        }

        // do in-order traversal
        printInOrder(root);
    }

    private static void printInOrder(Node root) {
        if(root == null) return;

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] inp = new int[n];
        
        for(int i = 0; i < n; i++) inp[i] = sc.nextInt();
        
        sol(n, inp);

        sc.close();
    }
}

