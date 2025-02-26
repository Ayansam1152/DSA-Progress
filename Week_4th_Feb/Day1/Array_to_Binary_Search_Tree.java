package Week_4th_Feb.Day1;

import Day3Of2ndWeekOfFeb.TreeNode;

class Array_to_Binary_Search_Tree {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return tree(nums, 0, nums.length-1);
    }

    private TreeNode tree(int nums[], int left, int right)
    {
        if(left > right) return null;

        int mid = left+(right-left)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = tree(nums, left, mid-1);
        root.right = tree(nums, mid+1, right);

        return root;
    }
}