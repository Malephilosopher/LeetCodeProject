package April.Day5;

public class Search2 {

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)return false;
        if(n == 1) return target == nums[0];
        int l = 0, r = n;

        while (l < r){
            int mid = (l + r) >> 1;
            if(nums[mid] == target){
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r - 1]) {
                ++l;
                --r;
            }else if(nums[l] <= nums[mid]){//如果左半段是有序的
                if(target >= nums[l] && target <= nums[mid]){
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }else{//如果右半段是有序的
                if(target > nums[mid] && target <= nums[r - 1]){
                    l = mid + 1;
                }else {
                    r = mid;
                }
            }

        }

        return false;
    }
}
