package leetcode.BinarySearch.SearchRange;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = getLeftBorder(nums, target);
        int right = getRightBorder(nums, target);
        //情况1：target的值在数组的范围外
        if(right == -2 || left == -2) return new int[]{-1, -1};
        //情况3：target在数组范围中，且数组有target
        if(right - left > 1) return new int[]{left + 1, right - 1};
        else {
            return new int[]{-1, -1};
        }
    }

    public int getRightBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    public int getLeftBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }
}
