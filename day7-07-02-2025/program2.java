/*
Given the preorder and postorder traversals of a binary tree, construct 
the original binary tree and print its level order traversal.

Input Format:
---------------
Space separated integers, pre order data
Space separated integers, post order data

Output Format:
-----------------
Print list of list of integers, the level-order data of the tree.


Sample Input:
----------------
1 2 4 5 3 6 7
4 5 2 6 7 3 1

Sample Output:
----------------
[[1], [2, 3], [4, 5, 6, 7]]

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4   5 6  7


Sample Input:
----------------
1 2 3
2 3 1

Sample Output:
----------------
[[1], [2, 3]]

Explanation:
--------------
    1
   / \
  2  3

*/

