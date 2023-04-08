package April.Day8;

import java.util.*;

public class LevelOrder {


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        if(root != null)queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0){
                Node cur = queue.poll();
                for (Node node: cur.children) {
                    queue.offer(node);
                }
                temp.add(cur.val);
            }
            ans.add(temp);
        }

        return ans;

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