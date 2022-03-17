package leetcode.SearchRotatedSortedArray;

public class SRSAPer {
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        if(n == 0) return false;
        if(n == 1) return nums[0] == target;
        while(l <= r)
        {
            int mid = (l + r) / 2;
            if(nums[mid] == target)
            {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) { //对于有重复元素的数组，如3, 2, 2, 3, 3, 3, 3, 无法判断有序的区间
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(search(nums,3));
    }
}
