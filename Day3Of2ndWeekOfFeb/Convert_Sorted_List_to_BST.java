package Day3Of2ndWeekOfFeb;

import Day2Of2ndWeekOfFeb.ListNode;

class Convert_Sorted_List_to_BST {
    /*
     * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
    height-balanced binary search tree.
     */
    public TreeNode sortedListToBST(ListNode head) {
        return tree(head);
    }

    private TreeNode tree(ListNode head)
    {
        // always think about base case
        // by the way great job vijay
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head, fast = head, preSlow = slow;
        
        while(fast != null && fast.next != null)
        {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        preSlow.next = null;
        root.left = tree(head);
        root.right = tree(slow.next);

        return root;        
    }
}