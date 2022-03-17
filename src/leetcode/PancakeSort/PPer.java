package leetcode.PancakeSort;

import java.util.ArrayList;
import java.util.List;

public class PPer {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        for (int n = arr.length; n > 1; n--) {
            int index = 0;
            for (int i = 1; i < n; i++) {
                //优先将后方的最大值反转
                index = arr[i] >= arr[index] ? i : index;
            }
            if(index == n - 1) continue;
            reverse(arr, index);
            reverse(arr, n - 1);
            ans.add(index + 1);
            ans.add(n);
        }
        return ans;
    }

    public void reverse(int[] arr, int end){
        for (int i = 0; i <= end >> 1; i++) {
            int temp = arr[i];
            arr[i] = arr[end - i];
            arr[end - i] = temp;
        }
    }

}
