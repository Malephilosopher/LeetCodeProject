package leetcode.Subsort;

//个人解法，用while循环超出时间限制
public class SubsortPer {
    public int[] subSort(int[] array) {
        int m = 0, n = array.length - 1;
        if(array.length == 0) return new int[]{-1, -1};
        else {
            int max = array[0], min = array[array.length - 1];
            int l = -1, r = -1;
            while (m <= array.length - 1)
            {
                if (array[m] >= max) {
                    max = array[m];
                    m++;
                }
                else {
                    r = m;
                    break;
                }
            }
            while(n >= 0)
            {
                if(array[n] <= min)
                {
                    min = array[n];
                    n--;
                }
                else {
                    l = n;
                    break;
                }
            }
            return new int[] {l, r};
        }
    }
}
