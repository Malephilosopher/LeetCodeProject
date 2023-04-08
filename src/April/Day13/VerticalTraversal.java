package April.Day13;

import java.util.*;

public class VerticalTraversal {

    Map<TreeNode, int[]> map = new HashMap<>(); // col, row, val
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map.put(root, new int[]{0, 0, root.val});
        dfs(root);
        List<int[]> list = new ArrayList<>(map.values());
        list.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        int n = list.size();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; ) {
            int j = i;
            List<Integer> tmp = new ArrayList<>();
            while (j < n && list.get(j)[0] == list.get(i)[0]) tmp.add(list.get(j++)[2]);
            ans.add(tmp);
            i = j;
        }
        return ans;
    }
    void dfs(TreeNode root) {
        if (root == null) return ;
        int[] info = map.get(root);
        int col = info[0], row = info[1], val = info[2];
        if (root.left != null) {
            map.put(root.left, new int[]{col - 1, row + 1, root.left.val});
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, new int[]{col + 1, row + 1, root.right.val});
            dfs(root.right);
        }
    }

    Map<TreeNode, Integer> node2col = new HashMap<>(), node2row = new HashMap<>();
    Map<Integer, Map<Integer, List<Integer>>> col2row2nodes = new HashMap<>();
    public List<List<Integer>> verticalTraversal1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        node2col.put(root, 0);
        node2row.put(root, 0);
        dfs1(root);
        dfs2(root);
        List<Integer> cols = new ArrayList<>(col2row2nodes.keySet());
        Collections.sort(cols);
        for (int col : cols) {
            Map<Integer, List<Integer>> row2nodes = col2row2nodes.get(col);
            List<Integer> rows = new ArrayList<>(row2nodes.keySet());
            Collections.sort(rows);
            List<Integer> cur = new ArrayList<>();
            for (int row : rows) {
                List<Integer> nodes = row2nodes.get(row);
                Collections.sort(nodes);
                cur.addAll(nodes);
            }
            ans.add(cur);
        }
        return ans;
    }
    // 树的遍历，根据「节点到列」&「节点到行」的映射关系，构造出「从列到行，从行到节点集」的映射关系
    void dfs2(TreeNode root) {
        if (root == null) return ;
        int col = node2col.get(root), row = node2row.get(root);
        Map<Integer, List<Integer>> row2nodes = col2row2nodes.getOrDefault(col, new HashMap<>());
        List<Integer> nodes = row2nodes.getOrDefault(row, new ArrayList<>());
        nodes.add(root.val);
        row2nodes.put(row, nodes);
        col2row2nodes.put(col, row2nodes);
        dfs2(root.left);
        dfs2(root.right);
    }
    // 树的遍历，记录下「节点到列」&「节点到行」的映射关系
    void dfs1(TreeNode root) {
        if (root == null) return ;
        if (root.left != null) {
            int col = node2col.get(root);
            node2col.put(root.left, col - 1);
            int row = node2row.get(root);
            node2row.put(root.left, row + 1);
            dfs1(root.left);
        }
        if (root.right != null) {
            int col = node2col.get(root);
            node2col.put(root.right, col + 1);
            int row = node2row.get(root);
            node2row.put(root.right, row + 1);
            dfs1(root.right);
        }
    }

}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }