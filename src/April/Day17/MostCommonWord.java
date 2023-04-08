package April.Day17;

import java.util.*;

public class MostCommonWord {



    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));

        String ans = "";
        Map<String, Integer> map = new HashMap<>();

        int n = paragraph.length();
        StringBuilder sb = new StringBuilder(paragraph.toLowerCase());
        for (int i = 0; i < n; i++) {
            char c = paragraph.charAt(i);
            if(!Character.isAlphabetic(c)){
                sb.setCharAt(i, ' ');
            }
        }
        String[] words = sb.toString().split(" ");
        for (String word: words) {
            if(Objects.equals(word, ""))continue;
            if(!set.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int max = 0;
        for (String key: map.keySet()) {
            int count = map.get(key);
            if(count > max){
                ans = key;
                max = count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord("a, a, a, b,b,b,b,c, c", new String[]{"a"}));

    }
}
