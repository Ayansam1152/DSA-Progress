package Week_4th_Feb.Day2;

import Week_4th_Feb.Day1.Node;

class Min_distance_between_two_given_nodes_of_a_Binary_Tree {
    int findDist(Node root, int a, int b) {
        // Your code here
        if(root == null) return 0;
        
        Node lca = LCA(root, a,b);
        int d1 = dist(lca, a,0);
        int d2 = dist(lca, b,0);
        
        return d1+d2;
        
    }
    
    private Node LCA(Node root, int a, int b)
    {
        if(root == null) return null;
        
        if(root.data == a || root.data == b)
        {
            return root;
        }
        
        Node left = LCA(root.left, a,b);
        Node right = LCA(root.right, a,b);
        
        if(left == null && right == null) return null;
        
        if(left != null && right != null) return root;
        
        if(left != null) return left;
        
        return right;
    }
    
    private int dist(Node root, int k, int dis)
    {
        if(root == null) return 0;
        
        if(root.data == k)
        {
            return dis;
        }
        
        int left = dist(root.left, k, dis+1);
        int right = dist(root.right, k, dis+1);
        
        return Math.max(left, right);
    }
}