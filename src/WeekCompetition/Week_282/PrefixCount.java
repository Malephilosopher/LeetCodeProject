package WeekCompetition.Week_282;

public class PrefixCount {

    public int prefixCount(String[] words, String pref) {
        int n = pref.length();
        int ans = 0;
        for (String word: words) {
            if(word.length() >= n && word.substring(0, n).equals(pref)){
                ans++;
            }
        }
        return ans;
    }
}
