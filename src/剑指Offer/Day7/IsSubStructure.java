package 剑指Offer.Day7;

import leetcode.String.ReverseOnlyLetters.RPer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //先在A中找B的根结点
        Deque<TreeNode> stack = new LinkedList<>();
        if(A == null) return B == null;
        if(B == null) return false;
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        TreeNode node = A;
        boolean found = false;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                if(node.val == B.val){
                    found = true;
                }
                if(found){
                    a.add(node.val);
                }
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        if(!found) return false;

        //然后单独拿出那个子树遍历和B比较
        node = B;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                b.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }



        return compare(a, b);
    }

    public boolean compare(List<Integer> a, List<Integer> b){
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i) == b.get(0)){
                int index = i;
                boolean complete = true;
                for (int j = 0; j < b.size(); j++, index++) {
                    if(index == a.size() || a.get(index) != b.get(j)){
                        complete = false;
                        break;
                    }
                    if(j == b.size() - 1) break;
                }
                if(complete) return true;
            }
        }
        return false;
    }

    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure1(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    public static void main(String[] args) {
        IsSubStructure subStructure = new IsSubStructure();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(0);
        a.add(-4);
        a.add(-3);
        a.add(1);
        b.add(1);
        b.add(-4);
        System.out.println(subStructure.compare(a, b));
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}