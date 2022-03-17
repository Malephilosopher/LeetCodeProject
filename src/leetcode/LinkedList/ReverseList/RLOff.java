package leetcode.LinkedList.ReverseList;

public class RLOff {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur)
    {
        if(cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
        return reverse(pre, cur);
    }
}
