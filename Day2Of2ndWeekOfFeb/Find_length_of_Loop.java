package Day2Of2ndWeekOfFeb;

public class Find_length_of_Loop {
    public class Node {
        int data;
        Node next;
    
        Node(int d) {
            data = d;
            next = null;
        }
    }
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Logic simple once you find the loop, move one pointer next and move util came back to same node 

        Node slow = head, fast = head;
        int count =1;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                slow = slow.next;
                while(slow != fast)
                {
                    count = count+1;
                    slow = slow.next;
                }
                
                return count;
            }
        }
        
        return 0;
        /*
        if(!isLoop) return 0;
        
        fast = head;
        System.out.print("I am from out side of ...");
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        int count = 1;
        
        fast = fast.next;
        while(slow != fast)
        {
            count++;
            fast = fast.next;
        }
        
        return count;
        */
    }
}