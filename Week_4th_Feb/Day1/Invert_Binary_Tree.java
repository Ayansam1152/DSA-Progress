package Week_4th_Feb.Day1;

import Day3Of2ndWeekOfFeb.TreeNode;

class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode temp = left;
        root.left = right;
        root.right = temp;

        return root;
    }
}