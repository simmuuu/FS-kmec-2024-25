# DS - MCQ

### Question 1
What is the maximum number of nodes in a binary tree of height `h` (where height is counted as the number of edges from root to the deepest node)?  
- a. \( (2^h - 1) \)  
- b. \( (2^{h+1} - 1) \)  
- c. \( (h \log h) \)  
- d. \( (h^2) \)  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** b. \( (2^{h+1} - 1) \)  

  **Explanation:**  
  A full binary tree of height `h` has the maximum number of nodes when all levels are completely filled. The number of nodes in a full binary tree of height `h` is given by:  
  \[
  N = 2^{h+1} - 1
  \]  
  This accounts for a root node and all the nodes at each subsequent level.  
</details>  

---

### Question 2
Consider the following pseudo-code for a function `func(Node root)` applied to a binary tree. What does it compute?  
```
Function func(Node root):
    if root is NULL:
        return 0
    return 1 + func(root.left) + func(root.right)
```
- a. Maximum depth of the tree  
- b. Height of the tree  
- c. Number of nodes in the tree  
- d. Sum of all node values  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** c. Number of nodes in the tree  

  **Explanation:**  
  The function recursively counts the number of nodes in the tree by adding 1 (for the current node) to the total count from the left and right subtrees.  
</details>  

---

### Question 3
Which of the following is always true for a full binary tree with `n` nodes?  
- a. The height of the tree is always `log n`  
- b. The tree is always balanced  
- c. Every level is completely filled  
- d. Every node has either 0 or 2 children  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** d. Every node has either 0 or 2 children  

  **Explanation:**  
  A **full binary tree** is a tree where every node has either 0 or 2 children. However, it does not necessarily mean that all levels are completely filled (which would make it a **complete** binary tree).  
</details>  

---

### Question 4
Given a BST, which of the following elements will always be found in the left subtree of a node with value `x`?  
- a. All elements in the tree  
- b. Elements less than `x`  
- c. Elements equal to `x`  
- d. Elements greater than `x`  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** b. Elements less than `x`  

  **Explanation:**  
  In a **Binary Search Tree (BST)**, all elements in the left subtree of a node are strictly less than the node’s value, while elements in the right subtree are greater.  
</details>  

---

### Question 5
What is the output of the following function when applied to a BST?  
```
Function findMin(Node root):
    if root is NULL:
        return NULL
    if root.left is NULL:
        return root.data
    return findMin(root.left)
```
- a. The height of the BST  
- b. The maximum value in the BST  
- c. The minimum value in the BST  
- d. The sum of all nodes  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** c. The minimum value in the BST  

  **Explanation:**  
  The function follows the leftmost path of the BST, which always leads to the smallest value in the tree.  
</details>  

---

### Question 6
What is the worst-case time complexity of deleting a node in an unbalanced BST with `n` nodes?  
- a. \( O(n) \)  
- b. \( O(\log n) \)  
- c. \( O(1) \)  
- d. \( O(n \log n) \)  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** a. \( O(n) \)  

  **Explanation:**  
  In an **unbalanced BST**, deletion might require traversal down a linear-height tree (e.g., a skewed BST), leading to an \( O(n) \) worst-case time complexity.  
</details>  

---

### Question 7
Which of the following statements is true for Dijkstra's Algorithm?  
- a. It finds the shortest path between all pairs of nodes  
- b. It guarantees the shortest path in all cases  
- c. It works only for graphs with non-negative weights  
- d. It works correctly with negative-weight cycles  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** c. It works only for graphs with non-negative weights  

  **Explanation:**  
  Dijkstra’s algorithm fails with negative-weight cycles because it assumes that a shorter path is always found by adding positive edge weights.  
</details>  

---

### Question 8
What is the time complexity of Depth-First Search (DFS) on a graph with `V` vertices and `E` edges using an adjacency matrix?  
- a. \( O(E \log V) \)  
- b. \( O(V^2) \)  
- c. \( O(V + E) \)  
- d. \( O(V) \)  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** b. \( O(V^2) \)  

  **Explanation:**  
  When using an **adjacency matrix**, checking neighbors of a vertex takes \( O(V) \) time, and DFS visits each vertex once, leading to an overall \( O(V^2) \) complexity.  
</details>  

---

### Question 9
Which traversal method should be used to determine if a directed graph contains a cycle?  
- a. Breadth-First Search (BFS)  
- b. Depth-First Search (DFS) with recursion stack  
- c. Kruskal's Algorithm  
- d. Dijkstra's Algorithm  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** b. Depth-First Search (DFS) with recursion stack  

  **Explanation:**  
  **DFS with a recursion stack** is a standard approach for cycle detection in directed graphs. If a back edge is found, it indicates a cycle.  
</details>  

---

### Question 10
What is the output of the following function when applied to an undirected graph represented as an adjacency list?  
```
Function fun(Node start):
    Queue Q
    Add start to Q
    While Q is not empty:
        Node u = Q.dequeue()
        print u
        For each neighbor v of u:
            If v is not visited:
                Mark v as visited
                Add v to Q
```
- a. Detection of cycles  
- b. Breadth-First Traversal  
- c. Finding the minimum spanning tree  
- d. Depth-First Traversal  

<details>
  <summary>Answer & Explanation</summary>
  
  **Answer:** b. Breadth-First Traversal  

  **Explanation:**  
  The function implements **Breadth-First Search (BFS)** using a queue to visit all nodes level by level.  
</details>  

