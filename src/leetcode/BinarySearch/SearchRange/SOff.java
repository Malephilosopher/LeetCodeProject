package leetcode.BinarySearch.SearchRange;

public class SOff {
    //先找>=target的第一个
    //再找>target的第一个
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums,target);
        int r = search(nums,target + 1);
        if(l == nums.length || nums[l] != target)
            return new int[]{-1, -1};
        return new int[]{l, r - 1};
    }
    //找>=target的第一个
    public int search(int[] nums,int target){
        int l = 0, r = nums.length;
        while(l < r){
            int mid = (r + l) >> 1;
            if(nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
