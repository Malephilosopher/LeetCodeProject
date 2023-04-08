package April.Day6;

public class FindMin1 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if(r == 0)return nums[0];
        while (l < r){
            int m = (l + r) >> 1;
            if(nums[m] < nums[r]){//如果右边有序
                r = m;
            }else if(nums[m] > nums[r]){//如果右边无序，那么左边肯定有序
                l = m + 1;
            }else {
                r--;
            }
        }
        return nums[l];
    }
}
