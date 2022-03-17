package leetcode.BinaryTree.Preorder;

import java.util.ArrayList;
import java.util.List;

public class PPer {
    List<Integer> preorder = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if(root != null)
        {
            preorder.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                preorder(root.children.get(i));
            }
        }
        return preorder;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}