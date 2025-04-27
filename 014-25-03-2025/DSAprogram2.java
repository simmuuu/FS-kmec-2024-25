/*In Marketing Job, each agent will mentor atmost two sub-agents. 
At the end, all mentor agents and sub agents, will be treated as agents only.

Now, you are given the sales data of two months as a tree, tree contains the 
count of the items sold by each agent, few agents might join the job and 
few might left the job.

You are given the sales data as month-1 and month-2.
Your task is to find get the combined report of two months data.

Implement the class Solution:
   1. public TreeNode combinedReport(TreeNode root1, TreeNode root2): 
    returns the root node of the combined data.

NOTE:
	- In the tree '-1', indicates no sales(null).

Input Format:
-------------
Line-1: space separated integers, sales data of month-1
Line-2: space separated integers, sales data of month-2

Output Format:
--------------
Print list of integers, with combined sales data.


Sample Input-1:
---------------
2 5 2 -1 -1 -1 4
1 2 3 4 5

Sample Output-1:
----------------
3 7 5 4 5 4


Sample Input-2:
---------------
1 2 3 4
1

Sample Output-2:
----------------
2 2 3 4
*/


import java.util.*;

class TreeNode {
    Integer val;
    TreeNode left, right;
    
    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution{
    public TreeNode combinedReport(TreeNode r1, TreeNode r2){
        if (r1 == null && r2 == null) return null;
        else if (r1 == null && r2 != null) return r2;
        else if (r1 != null && r2 == null) return r1;
        else {
            TreeNode r = new TreeNode((r1.val + r2.val));
            r.left = combinedReport(r1.left, r2.left);
            r.right = combinedReport(r1.right, r2.right);
            return r;
        }
    }
    
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            result.add(curr.val);
            
            if (curr.left != null) {
                queue.add(curr.left);
            }
            
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        
        return result;
    }
}