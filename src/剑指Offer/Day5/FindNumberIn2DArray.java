package 剑指Offer.Day5;

public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        if(m == 0) return false;

        int[] firstColumn = new int[n];
        //O(n)
        for (int i = 0; i < n; i++) {
            firstColumn[i] = matrix[i][0];
        }
        //搜索应该开始的行
        //O(logn)
        int startRow = binarySearch(firstColumn, target);
        if(startRow < n && matrix[startRow][0] == target) return true;
        startRow--;
        boolean ans = false;
        //从开始行一直从后往前搜索，每一行用二分查找
        //O(nlogm)
        for (int i = startRow; i >= 0; i--) {
            //如果这一行最后一个都比target小，就跳过
            if(matrix[i][m - 1] < target) continue;
            int result = binarySearch(matrix[i], target);
            if(matrix[i][result] == target){
                ans = true;
                break;
            }
        }

        return ans;
    }


    //找到大于等于target的第一个数
    public int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length;
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

    public static void main(String[] args) {
        FindNumberIn2DArray f = new FindNumberIn2DArray();
        int[][] nums = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(f.findNumberIn2DArray(nums, 5));
    }
}
