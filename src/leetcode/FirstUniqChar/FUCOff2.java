package leetcode.FirstUniqChar;

import java.util.HashMap;
import java.util.Map;

//用哈希表存储字符和索引，如果重复则索引为-1
public class FUCOff2 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> position = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!position.containsKey(ch))
            {
                position.put(ch, -1);
            }
            else {
                position.put(ch, i);
            }
        }
        int first = s.length();
        for (Map.Entry<Character, Integer> entry: position.entrySet()) {
            int pos = entry.getValue();
            if(pos != -1 && pos < first)
            {
                first = pos;
            }
           if(first == s.length())
            {
                first = -1;
            }
        }
        return first;
    }
}
