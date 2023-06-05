package US.TopInterviewQuestions.Array.PlusOne;

public class Solution {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        return add(digits, n - 1);
    }

    public int[] add(int[] digits, int index){
        if(index == -1){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        int digit = digits[index];
        if(digit == 9){
            digits[index] = 0;
            return add(digits, index - 1);
        }else {
            digits[index]++;
        }
        return digits;
    }
}
