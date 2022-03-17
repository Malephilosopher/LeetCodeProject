package leetcode.XorQueries;

import java.util.ArrayList;
import java.util.List;

public class XQPer {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] ans = new int[queries.length];
        int[] xors = new int[n + 1];
        xors[0] = 0;//第一位是0
        //构造前缀数组
        List a = new ArrayList();
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = xors[left] ^ xors[right + 1];
        }
        return ans;
    }


}
