package leetcode.Subsort;

//别人的解法，用for循环不超出时间限制
public class SubsortOth {
    public int[] subSort(int[] array) {

        if (array.length == 0) return new int[]{-1,-1};

        int start = 0;
        int max = array[0];

        int r = -1;
        for (int i = 1; i < array.length; i++) {

            if (array[i] >= max) {
                max = array[i];
            }else {
                r = i;
            }
        }

        int l = -1;
        int min = array[array.length - 1];
        for (int i =  array.length-1; i >= 0; i--) {

            if (array[i] <= min) {
                min = array[i];
            }else {
                l = i;
            }
        }
        return new int[]{l, r};
    }
}
