package Day3Of2ndWeekOfFeb;

import java.util.Stack;

import Day2Of2ndWeekOfFeb.ListNode;

public class Add_Two_Numbers_II {
    /*
     *  Input: l1 = [7,2,4,3], l2 = [5,6,4]
        Output: [7,8,0,7]
        Sum from end of list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while(l1 != null)
        {
            s1.push(l1);
            l1 = l1.next;
        }

        while(l2 != null)
        {
            s2.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode pre = null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0)
        {
            int val1 = s1.isEmpty() ? 0 : s1.pop().val;
            int val2 = s2.isEmpty() ? 0 : s2.pop().val;

            int sum = val1 +val2 +carry;
            carry = sum/10;

            ListNode curr = new ListNode(sum%10);
            curr.next = pre;
            pre = curr;
        }

        return pre;
    }
}