package leetcode.BinaryTree.FindMode;

import java.util.ArrayList;
import java.util.List;

public class FMOff {
    private int maxCount; // 最大频率
    private int count; // 统计频率
    private TreeNode pre;
    private List<Integer> result = new ArrayList<>();

    public void searchBST(TreeNode cur) {
        if (cur == null) return;

        searchBST(cur.left);       // 左
        // 中
        if (pre == null) { // 第一个节点
            count = 1;
        } else if (pre.val == cur.val) { // 与前一个节点数值相同
            count++;
        } else { // 与前一个节点数值不同
            count = 1;
        }
        pre = cur; // 更新上一个节点

        if (count == maxCount) { // 如果和最大值相同，放进result中
            result.add(cur.val);
        }

        if (count > maxCount) { // 如果计数大于最大值频率
            maxCount = count;   // 更新最大频率
            result.clear();     // 很关键的一步，不要忘记清空result，之前result里的元素都失效了
            result.add(cur.val);
        }

        searchBST(cur.right);      // 右
    }

    public int[] findMode(TreeNode root) {
        count = 0;
        maxCount = 0;
        TreeNode pre = null; // 记录前一个节点
        result.clear();
        searchBST(root);
        int[] a = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            a[i] = result.get(i);
        }
        return a;
    }
}
