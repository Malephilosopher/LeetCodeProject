package 剑指Offer.Day4;

public class Search {

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target);
        int rightIdx = binarySearch(nums, target + 1) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

}
