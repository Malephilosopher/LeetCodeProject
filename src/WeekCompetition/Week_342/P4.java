package WeekCompetition.Week_342;

public class P4 {

    public int minOperations(int[] nums) {
        int n = nums.length;
        boolean hasOdd = false;
        for (int i = 0; i < n; i++) {
            if(nums[i] % 2 == 1){
                hasOdd = true;
            }
        }
        if(!hasOdd)return -1;

        return 0;
    }

    public int gcd(int val1, int val2){
        while (val2 != 0) {
            int temp = val2;
            val2 = val1 % val2;
            val1 = temp;
        }

        return val1;



    }
}
