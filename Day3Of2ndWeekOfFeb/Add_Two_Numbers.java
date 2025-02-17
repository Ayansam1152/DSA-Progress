package Day3Of2ndWeekOfFeb;

import Day2Of2ndWeekOfFeb.ListNode;

public class Add_Two_Numbers {
    /*
     *  Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
     */
    int cary = 0;

    public ListNode addTwoNumbersUsingLoop(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            curr.next = node;
            curr = curr.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && cary == 0)
            return null;

        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;

        int sum = val1 + val2 + cary;
        cary = sum / 10;
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;

        ListNode head = new ListNode(sum % 10, addTwoNumbers(l1, l2));
        return head;
    }
}