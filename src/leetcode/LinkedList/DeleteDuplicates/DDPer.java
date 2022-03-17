package leetcode.LinkedList.DeleteDuplicates;

/*
1ms 32.99% O(n)
37.7MB 80% 1
 */
public class DDPer {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode node = dummy;
        while(node.next != null && node.next.next != null)
        {
            ListNode left = node.next;
            while(left.next != null && left.val == left.next.val)
            {
                ListNode right = left.next.next == null ? null : left.next.next;
                left.next.next = null;
                left.next = right;
            }
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.println(deleteDuplicates(node1).val);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}