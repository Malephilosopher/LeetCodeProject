package WeekCompetition.Week_277;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/23 11:02
 */
public class MaximumGood {

    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int ans = 0;
        int index = 0;
        boolean[] goodOrBad = new boolean[n];
        Arrays.fill(goodOrBad, false);
        //选择一个突破点
        for (int i = 0; i < n; i++) {
            boolean f = false;
            for (int j = 0; j < n; j++) {
                if(statements[i][j] == 0){
                    index = i;
                    f = true;
                    break;
                }
            }
            if(f){
                break;
            }
        }

        //假设突破点是好人
        goodOrBad[index] = true;
        for (int i = 0; i < n; i++) {
            if(i == index) continue;
            int num = statements[index][i];
            int[] statement = statements[i];
            if(num == 0){
                for (int j = 0; j < n; j++) {
                    if(statement[j] == 0){
                        goodOrBad[j] = true;
                    }else if(statement[j] == 1){
                        goodOrBad[j] = false;
                    }
                }
            }
            else if(num == 1){
                goodOrBad[i] = true;
                for (int j = 0; j < n; j++) {
                    if (statement[j] == 1) {
                        goodOrBad[j] = true;
                    }else if(statement[j] == 0){
                        goodOrBad[j] = false;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(goodOrBad[i]){
                ans++;
            }
        }

        //假设突破点是坏人且说假话
        Arrays.fill(goodOrBad, false);
        for (int i = 0; i < n; i++) {
            if(i == index) continue;
            int num = statements[index][i];
            int[] statement = statements[i];
            if(num == 0){
                goodOrBad[i] = true;
                for (int j = 0; j < n; j++) {
                    if (statement[j] == 1) {
                        goodOrBad[j] = true;
                    }else if(statement[j] == 0){
                        goodOrBad[j] = false;
                    }
                }
            }
            else if(num == 1) {
                for (int j = 0; j < n; j++) {
                    if(statement[j] == 0){
                        goodOrBad[j] = true;
                    }else if(statement[j] == 1){
                        goodOrBad[j] = false;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(goodOrBad[i]){
                count++;
            }
        }
        return Math.max(ans, count);
    }

    public static void main(String[] args) {
        MaximumGood maximumGood = new MaximumGood();
        int[][] statements = {{2,1,2},{1,2,2},{2,0,2}};
        System.out.println(maximumGood.maximumGood(statements));
    }
}
