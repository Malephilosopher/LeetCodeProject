package leetcode.LinkedList.DeleteDuplicates2;


import java.util.*;

/*
6ms 7.11%
38.3MB 5.06%
 */
public class DD2Per {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
        {
            return null;
        }
        if(head.next == null)
        {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        Hashtable<Integer, ListNode> map = new Hashtable<>();
        List<Integer> toBeRemoved = new ArrayList<>();
        while(dummy.next != null)
        {
            if(map.containsKey(dummy.val))
            {
                toBeRemoved.add(dummy.val);
                dummy = dummy.next;
                continue;
            }
            map.put(dummy.val, dummy);
            dummy = dummy.next;
        }
        if(map.containsKey(dummy.val)) {
            toBeRemoved.add(dummy.val);
        }else {
            map.put(dummy.val, dummy);
        }
        for (int i = 0; i < toBeRemoved.size(); i++) {
            map.remove(toBeRemoved.get(i));
        }
        ListNode dummy1 = new ListNode(Integer.MIN_VALUE);
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        for (int i = 0; i < keys.length; i++) {
            dummy1.next = map.get(keys[i]);
            dummy1 = dummy1.next;
        }
        dummy1.next = null;
        if(keys.length == 1)
        {
            return null;
        }
        return map.get(keys[1]);
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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}