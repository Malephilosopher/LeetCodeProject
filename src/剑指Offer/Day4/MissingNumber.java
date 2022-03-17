package 剑指Offer.Day4;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) >> 1;
            //右区间有缺失
            if(nums[mid] == mid){
                left = mid + 1;
            }else {//左区间有缺失
                right = mid - 1;
            }
        }
        return left;

    }
}
