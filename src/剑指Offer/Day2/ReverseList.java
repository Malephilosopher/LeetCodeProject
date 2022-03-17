package 剑指Offer.Day2;

public class ReverseList {

    private ListNode h;

    public ListNode reverseList(ListNode head) {
        dfs(head);
        return h;
    }

    public void dfs(ListNode head){
        if(head.next == null) {
            h = head;
            return;
        }
        dfs(head.next);
        ListNode next = head.next;
        head.next = null;
        next.next = head;
    }
}
