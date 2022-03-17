package WeekCompetition.Week_276;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/16 10:30
 */
public class DivideString {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = n / k;
        int left = n % k;
        String[] ans = new String[groups + (left == 0 ? 0 : 1)];
        for (int i = 0; i < groups; i++) {
            ans[i] = s.substring(i * k, i * k + k);
        }
        if(left > 0){
            StringBuilder stringBuilder = new StringBuilder(s.substring(groups * k));
            while (stringBuilder.length() < k){
                stringBuilder.append(fill);
            }
            ans[groups] = stringBuilder.toString();
        }
        return ans;

    }
}
