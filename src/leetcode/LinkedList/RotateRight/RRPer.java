package leetcode.LinkedList.RotateRight;


/*
1ms 51.22%
38.1MB 10.76%
 */
public class RRPer {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode node = dummy;
        ListNode[] nodes = new ListNode[500];
        int l = 0;
        for (int i = 0; i < 500; i++) {
            if(node.next == null)
            {
                break;
            }
            nodes[i] = node.next;
            node = node.next;
            l++;
        }
        k %= l;
        ListNode[] target = new ListNode[l];
        for (int i = 0; i < l; i++) {
            int index = (i + k + l) % l;
            target[index] = nodes[i];
        }
        target[l - 1].next = null;
        for (int i = 0; i < l - 1; i++) {
            target[i].next = target[i + 1];
        }
        return target[0];
    }
}
