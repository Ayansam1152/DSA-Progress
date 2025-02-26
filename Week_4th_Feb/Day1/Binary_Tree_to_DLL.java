package Week_4th_Feb.Day1;

class Binary_Tree_to_DLL
{
    /*
     * Given a Binary Tree (BT), convert it to a Doubly Linked List (DLL) in place. 
     * The left and right pointers in nodes will be used as previous and next pointers respectively in converted DLL.
     */
    Node pre = null, head = null;
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	    if(root == null) return null;
	    
	   // Node head= null;
	    help(root);
	    
	    return head;
    }
    
    void help(Node root)
    {
	//  Your code here	
	    if(root == null) return ;
	    
	    help(root.left);
	    
	    if(pre == null)
	    {
	        head = root;
	    }
	    else
	    {
	        root.left = pre;
	        pre.right = root;
	    }
	    
	    // before going to right subtree pre should be move to curr think about it.
	    // in below logic you called right part but pre you are not updating that is why it is going wrong.
	    pre = root;
	    
	    help(root.right);
	    
	    /*
	    Nice try but some logic missing.
	    cur.left = pre;
	    if(pre != null)
	    {
	    pre.right = cur;
	    }
	    
	    Node next = help(root.right);
	    cur.right = next;
	    if(next != null)
	    {
	        next.left = cur;
	    }
	    
	    return cur.right==null ? cur : cur.right;
	    */
    }
}