package leetcode.SlideWindow.FindRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FPer {

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if(n <= 10) return ans;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            if(set.contains(sub)){
                if(!ans.contains(sub)){
                    ans.add(sub);
                }
            }else {
                set.add(sub);
            }
        }
        return ans;

    }
}
