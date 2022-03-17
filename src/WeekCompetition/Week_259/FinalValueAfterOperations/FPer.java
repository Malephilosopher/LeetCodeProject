package Week_259.FinalValueAfterOperations;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/19 11:14
 */
public class FPer {

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation: operations) {
            if("++X".equals(operation) || "X++".equals(operation)){
                ans++;
            }else {
                ans--;
            }
        }
        return ans;
    }
}
