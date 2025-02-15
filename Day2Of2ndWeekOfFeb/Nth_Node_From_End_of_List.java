package Day2Of2ndWeekOfFeb;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Remove_Nth_Node_From_End_of_List {
    /*
     * Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head;

        while(n-->1)
        {
            slow = slow.next;
        }

        ListNode pre = fast;
        while(slow.next != null)
        {
            pre = fast;
            fast = fast.next;
            slow = slow.next;
        }

        if(pre == fast)
        {
            // edge case for linkedList
            return fast.next;
        }

        pre.next = fast.next;

        return head;
    }
}