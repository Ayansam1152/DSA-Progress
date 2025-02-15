package Day2Of2ndWeekOfFeb;

public class Merge_k_Sorted_Lists {

    /*
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
        Merge all the linked-lists into one sorted linked-list and return it.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length ==0) return null;
        ListNode head = mergeUsingRecursion(lists[0], null);

        for(int i=1;i<lists.length;i++)
        {
            head = mergeUsingRecursion(head,lists[i]);
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val > list2.val)
            return mergeTwoLists(list2, list1);
        ListNode h1 = list1, h2 = list2;
        ListNode newHead = h1, t = h1.next;

        while (h2 != null && t != null) {
            if (t.val <= h2.val) {
                t = t.next;
                h1 = h1.next;
            } else {
                h1.next = h2;
                h1 = h2;
                h2 = t;
                t = h1.next;
            }
        }

        h1.next = h2;

        return newHead;
    }

    private ListNode mergeUsingRecursion(ListNode h1, ListNode h2)
    {
        if(h1 == null) return h2;
        if(h2 == null) return h1;

        if(h1.val <= h2.val)
        {
            h1.next = mergeUsingRecursion(h1.next, h2);
            return h1;
        }
        else
        {
            h2.next = mergeUsingRecursion(h1, h2.next);
            return h2;
        }
    }
}