package leetcode.NumSubseq;

import java.util.Arrays;

public class NSPer {
    static int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res=0;
        int n=nums.length;
        int[] pow = new int[n];
        pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i]=pow[i-1]*2%mod;
        }
        int left=0,right=n-1;
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                res+=pow[right-left];
                res%=mod;
                left++;
            }
            else
                right--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 1, 7, 6, 8};
        int target = 16;
        NSPer n = new NSPer();
        System.out.println(n.numSubseq(nums, target));
    }
}
