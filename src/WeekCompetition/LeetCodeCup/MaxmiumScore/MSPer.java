package WeekCompetition.LeetCodeCup.MaxmiumScore;

import java.util.ArrayList;
import java.util.List;

public class MSPer {

    private int ans = 0;
    private List<Integer> list;

    public int maxmiumScore(int[] cards, int cnt) {
        list = new ArrayList<>();
        dfs(cards, cnt, 0, 0);
        return ans;
    }

    public void dfs(int[] cards, int cnt, int start, int sum){
        if(list.size() == cnt){
            if(sum % 2 == 0){
                ans = Math.max(ans, sum);
            }
            return;
        }

        for (int i = start; i < cards.length; i++) {
            sum += cards[i];
            list.add(cards[i]);
            dfs(cards, cnt, i + 1, sum);
            list.remove(list.size() - 1);
            sum -= cards[i];
        }
    }


}
