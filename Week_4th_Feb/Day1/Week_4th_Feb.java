package Week_4th_Feb.Day1;

import java.util.ArrayList;
import java.util.List;

import Day3Of2ndWeekOfFeb.TreeNode;

class Binary_Tree_Paths {
    /*
     * Given the root of a binary tree, return all root-to-leaf paths in any order.
    A leaf is a node with no children.
    Output: ["1->2->5","1->3"]
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // I am very proud of you Vijay, I can see your progress, this qns you have solved without looking hint or solutions
        // Thank you so much for your effort, once day you will make it
        List<String> paths = new ArrayList<>();
        path(root, "", paths);
        return paths;
    }

    private void path(TreeNode root, String path, List<String> list)
    {
        if(root == null) return ;

        if(root.left == null && root.right == null)
        {
            list.add(path+root.val);
            return ;
        }

        path(root.left,path+root.val+"->", list);
        path(root.right, path+root.val+"->", list);
    }
}