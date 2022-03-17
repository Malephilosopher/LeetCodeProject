package leetcode.SingleNonDuplicate;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/29 22:43
 */
public class SPer {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if(right == 1) return nums[0];
        while (left < right){
            int mid = (right + left) / 2;
            //中间元素和它左边的元素相等
            if(nums[mid] == nums[mid - 1]){
                //左半边数组长度为奇数
                if((mid - left - 1) % 2 == 1){
                    right = mid - 2;
                }else{ //左半边数组长度为偶数
                    left = mid + 1;
                }
            }else if(nums[mid] == nums[mid + 1]){ //中间元素和它右边的元素相等
                //左半边数组长度为奇数
                if((mid - left) % 2 == 1){
                    right = mid - 1;
                }else{ //左半边数组长度为偶数
                    left = mid + 2;
                }
            }else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
