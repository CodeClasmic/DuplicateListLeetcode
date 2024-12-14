import java.util.HashSet;
import java.util.Set;

public class duplicatelist {
    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public static duplicatelist.ListNode insert(ListNode head, int val) {
            ListNode node = new ListNode(val);
            if (head == null)
                return node;
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            return head;
        }
        public static void print(ListNode head)
        {
            ListNode current=head;
            while(current.next!=null)
            {
                System.out.print(current.val+"->");
                current=current.next;
            }
            System.out.println("null");
        }
       public static duplicatelist.ListNode duplicate(ListNode head) {
    if (head == null || head.next == null) {
        return head; // No duplicates possible with 0 or 1 node
    }

    Set<Integer> seen = new HashSet<>();
    ListNode current = head;
    ListNode prev = null;

    while (current != null) {
        if (seen.contains(current.val)) {
            // Remove duplicate
            prev.next = current.next;
        } else {
            // Add value to the set and move `prev`
            seen.add(current.val);
            prev = current;
        }
        current = current.next;
    }
    return head;
}

    }

    public static void main(String[] args) {
        ListNode head = null;
        head = ListNode.insert(head, 20);
        head = ListNode.insert(head, 223);
        head = ListNode.insert(head, 20);
        head = ListNode.insert(head, 78);
        head = ListNode.insert(head, 9);
        ListNode.print( head );
        head=ListNode.duplicate(head);
        ListNode.print( head );
    }

}
