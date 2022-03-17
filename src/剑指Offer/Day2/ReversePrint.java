package 剑指Offer.Day2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            list.add(p.val);
            p = p.next;
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[n - i - 1] = list.get(i);
        }
        return ans;
    }
    int[] res;
    int i = 0;
    int j = 0;
    public int[] reversePrint1(ListNode head) {
        solve(head);
        return res;
    }
    public void solve(ListNode head){
        if(head == null){
            res = new int[i];
            return;
        }
        i++;
        solve(head.next);
        res[j] = head.val;
        j++;
    }

    public static void main(String[] args) {
        ReversePrint reversePrint = new ReversePrint();
        ListNode h = new ListNode(1);
        h.next = new ListNode(3);
        h.next.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint.reversePrint1(h)));
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
