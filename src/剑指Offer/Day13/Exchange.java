package 剑指Offer.Day13;

import java.util.Arrays;

public class Exchange {

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            while (left < right && (nums[left] & 1) == 1)left++;
            while (left < right && (nums[right] & 1) == 0) right--;
            swap(nums, left, right);
        }
        return nums;
    }

    public void swap(int[] nums, int l, int r){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,8,9};
        Exchange c = new Exchange();
        System.out.println(Arrays.toString(c.exchange(nums)));
    }

}
