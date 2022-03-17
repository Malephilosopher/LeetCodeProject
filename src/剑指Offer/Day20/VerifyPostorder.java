package 剑指Offer.Day20;

public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    public boolean dfs(int[] postorder, int left, int right){
        if(left >= right) return true;
        int p = left;
        while(postorder[p] < postorder[right]) p++;
        int m = p;
        while(postorder[p] > postorder[right]) p++;

        return p == right && dfs(postorder, left, m - 1) && dfs(postorder, m, right - 1);
    }

}
