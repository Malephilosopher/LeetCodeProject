package leetcode.LinkedList.DeleteDuplicates2;

/*
1ms 65%
37.9MB 37%
 */
public class DD2Per1 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(head.val, head);
        ListNode node = dummy;
        while (node.next != null && node.next.next != null)
        {
            boolean flag = false;
            ListNode left = node.next;
            while (left.next != null && left.val == left.next.val)
            {
                left = left.next;
                flag = true;
            }
            if(flag)
            {
                node.next = left.next;
            }else {
                node = node.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(4);
//        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
        System.out.println(deleteDuplicates(node1).val);
    }
}
