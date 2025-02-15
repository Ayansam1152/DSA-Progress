package Day2Of2ndWeekOfFeb;

class Palindrome_Linked_List {
    // Simple logic Reverse the hal of the list and compare the value
    ListNode temp;
    public boolean isPalindrome(ListNode head) {
        // you will learn three things
        // 1. find the middle
        // 2. reverse the linkedlist
        // 3. check the palindrome
        if (head == null || head.next == null)
            return true;
        ListNode midNode = getMidNode(head);
        int length = getLength(head);
        ListNode head1 = reverse(head, midNode);

        if (length % 2 != 0) {
            midNode = midNode.next;
        }

        ListNode curr = head1;
        while (curr != null && midNode != null) {
            System.out.println("curr val : " + curr.val + "   mid.val: " + midNode.val);
            if (curr.val != midNode.val)
                return false;
            curr = curr.next;
            midNode = midNode.next;
        }

        return true;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private int getLength(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            // System.out.print(temp.val+"->");
            temp = temp.next;
            count++;
        }

        return count;
    }

    @SuppressWarnings("unused")
    private void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    private ListNode reverse(ListNode head, ListNode midNode) {
        ListNode pre = null, curr = head, next = head.next;
        while (curr != null && curr != midNode) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = curr.next;
        }

        return pre;
    }

    // Please check it out also
    @SuppressWarnings("unused")
    private ListNode reverseUsingRecursion(ListNode head)
    {
        if(head.next == null)
        {
            // this is for new Head
            temp = head;
            return head;
        }

        ListNode nodeFromEnd = reverseUsingRecursion(head.next);
        nodeFromEnd.next = head;

        return head;
    }
}