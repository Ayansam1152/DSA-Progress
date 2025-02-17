package Day3Of2ndWeekOfFeb;

import java.util.Stack;

public class Flatten_a_Multilevel_Doubly_Linked_List {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    // Logic is simple if node has child node then add child list between curr and next node 

    public Node flatten(Node head) {
        // when node has child node the store the next node in stack and make next node curr is child and child become null, repeat until list end
        if (head == null)
            return head;
        Stack<Node> futureNext = new Stack<>();

        Node curr = head, beforeNode = null;

        while (curr != null || !futureNext.isEmpty()) {

            while (curr != null) {
                if (curr.child != null) {
                    if (curr.next != null) {
                        futureNext.push(curr.next);
                    }
                    curr.next = curr.child;
                    curr.child.prev = curr;
                    curr.child = null;

                }
                beforeNode = curr;
                curr = curr.next;
            }
            if (futureNext.isEmpty())
                return head;
            Node nextNode = futureNext.pop();
            beforeNode.next = nextNode;
            nextNode.prev = beforeNode;
            curr = nextNode;
        }

        return head;
    }
}