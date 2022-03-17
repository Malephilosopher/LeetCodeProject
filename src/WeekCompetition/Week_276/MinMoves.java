package WeekCompetition.Week_276;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/16 10:41
 */
public class MinMoves {
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (target > 1){
            if(target % 2 == 0){
                if(maxDoubles > 0){
                    target /= 2;
                    count++;
                    maxDoubles--;
                }else {
                    return count + target - 1;
                }
            }else {
                target--;
                count++;
            }
        }
        return count;
    }
}
