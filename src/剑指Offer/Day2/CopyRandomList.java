package 剑指Offer.Day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Node pre = new Node(0);
        Node p = pre;
        List<Node> newNodes = new ArrayList<>();
        List<Node> oldNodes = new ArrayList<>();
        while (head != null){
            Node node = new Node(head.val);
            node.next = head.next;
            newNodes.add(node);
            p.next = node;
            p = node;
            oldNodes.add(head);
            head = head.next;
        }
        for (int i = 0; i < newNodes.size(); i++) {
            Node rand = oldNodes.get(i).random;
            int index = oldNodes.indexOf(rand);
            if(index < newNodes.size() && index >= 0){
                newNodes.get(i).random = newNodes.get(index);
            }
        }
        return pre.next;
    }

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList1(Node head) {
        //非空判断
        if(head == null) return null;

        if(!map.containsKey(head)){
            Node node = new Node(head.val);
            map.put(head, node);
            node.next = copyRandomList1(head.next);
            node.random = copyRandomList1(head.random);
        }
        return map.get(head);


    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }

    public Node copyRandomList3(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        //利用map建立原节点到新节点的一一对应关系
        HashMap<Node,Node> map = new HashMap<>();
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}