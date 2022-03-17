public class Test {

    public static int count(int[] arr, int target){
        if(arr == null) return 0;
        if(arr.length == 0) return 0;
        int left = first(arr, target);
        int right = first(arr, target + 1);
        if(arr[right] == target) right++;
        return right - 1 - left + 1;
    }

    //找到大于等于target的第一个下标
    public static int first(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 2, 6};
//        System.out.println(count(arr, 5));
        System.out.println(judge(7));
        System.out.println(judge(8));
    }

    public static boolean judge(int num){
        return (num & (num - 1)) == 0;
    }

}
