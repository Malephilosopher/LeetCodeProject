package leetcode.DynamicProgramming.GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/29 21:33
 */
public class GPer {

//    public List<String> generateParenthesis(int n) {
//        List<List<String>> dp = new ArrayList<>();
//        dp.add(List.of(new String[]{""}));
//        dp.add(List.of(new String[]{"()"}));
//        for (int i = 2; i <= n; i++) {
//            dp.add(new ArrayList<>());
//            for (int j = 0; j < i; j++) {
//                for (String p: dp.get(j)) {
//                    for (String q:dp.get(i - j - 1)) {
//                        String str = "(" + p + ")" + q;
//                        dp.get(i).add(str);
//                    }
//                }
//            }
//        }
//        return dp.get(n);
//
//    }
}
