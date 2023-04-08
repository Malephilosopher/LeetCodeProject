package April.Day10;

import java.util.List;

public class MaxDepth {

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int max = 0;
        for (Node son: root.children) {
            max = Math.max(max, maxDepth(son));
        }
        return 1 + max;
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