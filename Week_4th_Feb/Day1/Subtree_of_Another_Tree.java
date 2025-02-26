package Week_4th_Feb.Day1;

import java.util.LinkedList;
import java.util.Queue;

import Day3Of2ndWeekOfFeb.TreeNode;

class Subtree_of_Another_Tree {
    /*
     * Given the roots of two binary trees root and subRoot, 
     * return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // think about this approach
        //https://leetcode.com/problems/subtree-of-another-tree/solutions/102724/java-solution-tree-traversal/
        return check(root, subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            while(size-->0)
            {
                TreeNode node = q.poll();
                if(node.val == subRoot.val)
                {
                    if(isSame(node, subRoot))
                    {
                        return true;
                    }
                }

                if(node.left != null)
                {
                    q.add(node.left);
                }

                if(node.right != null)
                {
                    q.add(node.right);
                }
            }
        }

        return false;
    }
    
    // this is generic check for Identical tree.
    private boolean isSame(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}