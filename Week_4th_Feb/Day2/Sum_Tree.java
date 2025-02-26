package Week_4th_Feb.Day2;

import Week_4th_Feb.Day1.Node;

class Sum_Tree {
    /*
     * Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it
     */
    boolean isSumTree(Node root) {
        if(root == null) return true;
        
        if(root.left == null && root.right == null) return true;
       
        boolean isLeftSumTree = isSumTree(root.left);
        boolean isRightSumTree = isSumTree(root.right);
        
        if(!isLeftSumTree || !isRightSumTree)
        {
            return false;
        }
        
        // find sum of left sub tree and right subtree
        int leftSum = (root.left == null ) ? 0 : sum(root.left);
        int rightSum = (root.right == null) ? 0 : sum(root.right);
        
        
        return root.data == leftSum+rightSum;
        
        /* Nice try but some flaw in this code let's fix it
        Here you only checking with current node but you have to check for all node
        You can compre and later :)
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null)
        {
            return root.data == root.right.data;
        }
        
        if(root.right == null)
        {
            return root.data == root.left.data;
        }
        
        return root.data == (root.left.data+root.right.data) 
            && isSumTree(root.left) && isSumTree(root.right);
        */
    }
    
    private int sum(Node root)
    {
        if(root == null) return 0;
        
        return root.data + sum(root.left) + sum(root.right);
    }
}
