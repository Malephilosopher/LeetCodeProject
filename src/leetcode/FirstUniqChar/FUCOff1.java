package leetcode.FirstUniqChar;

import java.util.Hashtable;

//用哈希表存储字符和出现次数
public class FUCOff1 {
    public int firstUniqChar(String s) {
        Hashtable<Character, Integer> frequency = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(frequency.get(s.charAt(i)) == 1)
            {
                return i;
            }
        }
        return -1;

    }



}
