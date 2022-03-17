package leetcode.Array.NumberOfSteps;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/31 10:22
 */
public class NPer {

    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0){
            if(num % 2 == 0){
                num /= 2;
            }else {
                num--;
            }
            count++;
        }
        return count;
    }
}
