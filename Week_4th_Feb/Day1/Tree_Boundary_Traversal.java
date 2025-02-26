package Week_4th_Feb.Day1;

import java.util.ArrayList;
import java.util.List;

class Tree_Boundary_Traversal
{
    ArrayList<Integer> boundaryTraversal(Node node) {
        // Always break the problem in small steps then solve it 
        // you are doing good :)
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(node == null)
        {
            return list;
        }
        
        if(node.left == null && node.right == null)
        {
            list.add(node.data);
            
            return list;
        }
        
        
        list.add(node.data);
        
        leftTraversal(node.left, list);
        leafTraversal(node, list);
        rightTraversal(node.right, list);
        
        return list;
    }
    
    private void leftTraversal(Node root, List<Integer> list)
    {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        list.add(root.data);
        
        if(root.left != null)
        {
            leftTraversal(root.left, list);
        }
        else
        {
            leftTraversal(root.right, list);
        }
    }
    
    private void leafTraversal(Node root, List<Integer> list)
    {
        if(root == null) return;
        
        if(root.left == null && root.right == null)
        {
            list.add(root.data);
        }
        
        leafTraversal(root.left, list);
        leafTraversal(root.right, list);
    }
    
    private void rightTraversal(Node root, List<Integer> list)
    {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        if(root.right != null)
        {
            rightTraversal(root.right, list);
        }
        else
        {
            rightTraversal(root.left, list);
        }
        
        // this is returning time
        list.add(root.data);
    }
}