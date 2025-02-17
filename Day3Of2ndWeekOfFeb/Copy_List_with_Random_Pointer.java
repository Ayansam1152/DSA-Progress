package Day3Of2ndWeekOfFeb;

import java.util.HashMap;
import java.util.Map;

class Copy_List_with_Random_Pointer {
    public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
    public Node copyRandomList(Node head) {
        // done solved very optimize Please
        Node curr = head;
        Node preHead = new Node(-1);
        Node dummy = preHead;
        
        Map<Node,Node> map = new HashMap<>();
        // prepare new list with random pointer
        while(curr != null)
        {
            Node node = new Node(curr.val);
            map.put(curr,node);
            dummy.next = node;
            dummy = dummy.next;
            curr = curr.next;
        }
        
        // setup the random pointer
        curr = head;
        dummy = preHead.next;
        while(curr != null)
        {
            if(curr.random != null)
            {
                Node rand = map.get(curr.random);
                dummy.random = rand;
            }

            curr = curr.next;
            dummy = dummy.next;
        }

        return preHead.next;
    }
}