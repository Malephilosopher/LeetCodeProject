package leetcode.BinaryTree.Preorder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class POff {
    public List<Integer> preorder(Node root)
    {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root == null)
        {
            return output;
        }

        stack.add(root);
        while(!stack.isEmpty())
        {
            Node currentNode = stack.pollLast();
            output.add(currentNode.val);
            Collections.reverse(root.children);
            for (Node node: root.children) {
                stack.add(node);
            }
            return output;
        }


    return output;
    }
}
