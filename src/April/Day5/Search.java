package April.Day5;

public class Search {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 1) return target == nums[0] ? 0 : -1;
        int l = 0, r = n;

        while (l < r){
            int mid = (l + r) >> 1;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[l] < nums[mid]){//如果左半段是有序的
                if(target >= nums[l] && target <= nums[mid]){
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }else{//如果右半段是有序的
                if(target >= nums[mid + 1] && target <= nums[r - 1]){
                    l = mid + 1;
                }else {
                    r = mid;
                }
            }

        }

        return -1;
    }
}
