package leetcode.BinarySearch.SearchInsert;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if(target <  nums[left]) return 0;
        if(target > nums[right]) return right + 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                return mid; //循环正常终止，找到了target
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        } //循环不正常终止，没有找到target,此时right = left - 1
        return right + 1;
    }
}
