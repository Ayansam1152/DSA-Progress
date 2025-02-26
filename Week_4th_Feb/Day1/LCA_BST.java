package Week_4th_Feb.Day1;

import Day3Of2ndWeekOfFeb.TreeNode;

class LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return root;
        
        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        else
        {
            return root;
        }
    }
}