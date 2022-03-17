package 剑指Offer.Day15;

import java.util.ArrayList;
import java.util.List;

public class TreeToDoublyList {

    List<Node> list;

    public Node treeToDoublyList(Node root) {
        list = new ArrayList<>();
        dfs(root);
        Node head = new Node();
        int n = list.size();
        if(n == 0)return root;
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i).val);
        }
        head.right = list.get(0);
        for (int i = 0; i < n; i++) {
            Node node = list.get(i);
            node.right = list.get((i + 1) % n);
            node.left = list.get((i - 1) >= 0 ? i - 1 : n - 1);
        }
        return head.right;
    }

    public void dfs(Node root){
        if(root == null)return;

        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }

    Node pre, head;
    public Node treeToDoublyList1(Node root) {
        if(root == null) return null;
        dfs1(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs1(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}