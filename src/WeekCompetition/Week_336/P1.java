package WeekCompetition.Week_336;

public class P1 {

    //https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/


    public int vowelStrings(String[] words, int left, int right) {
        int n = words.length;
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String s = words[i];
            if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u'){
                if(s.charAt(s.length() - 1) == 'a' || s.charAt(s.length() - 1) == 'e' || s.charAt(s.length() - 1) == 'i' || s.charAt(s.length() - 1) == 'o' || s.charAt(s.length() - 1) == 'u'){
                    ans++;
                }
            }
        }
        return ans;
    }
}
