package WeekCompetition.Week7_25;

import java.util.HashMap;

public class P1 {

    public int getLucky(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> alphabets = new HashMap<>();
        char c = 'a';
        for (int i = 1; i < 27; i++) {
            alphabets.put(c++, i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(alphabets.get(chars[i]));
        }
        String s1 = stringBuilder.toString();
        for (int i = 0; i < k; i++) {
            s1 = sum(s1);
        }
        return Integer.parseInt(s1);
    }

    public String sum(String num){
        int ans = 0;
        for (int i = 0; i < num.length(); i++) {
            ans += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return String.valueOf(ans);
    }


}
