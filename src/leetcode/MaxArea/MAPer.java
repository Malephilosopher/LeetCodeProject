package leetcode.MaxArea;


public class MAPer {
    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int volume = 0;
        while(left < right)
        {
            volume = Math.max(volume, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right])
            {
                left++;
            }else {
                right--;
            }
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
