package WeekCompetition.LeetCodeCup.MaxmiumScore;

import java.util.*;

public class MSPer1 {

    public int maxmiumScore(int[] cards, int cnt) {
        int n = cards.length;
        Integer[] cards1 = new Integer[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            cards1[i] = cards[i];
        }
        Arrays.sort(cards1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        //向右偏移一个单位
        evens.add(0);
        odds.add(0);
        if(cards1[0] % 2 == 0){
            evens.add(cards1[0]);
        }else if(cards1[0] % 2 == 1){
            odds.add(cards1[0]);
        }
        for (int i = 1; i < n; i++) {
            if(cards1[i] % 2 == 0){
                evens.add(evens.get(evens.size() - 1) + cards1[i]);
            }else if(cards1[i] % 2 == 1){
                odds.add(odds.get(odds.size() - 1) + cards1[i]);
            }
        }

        for (int i = 0; i < odds.size(); i += 2) {
            if(cnt - i >= 0 && cnt - i < evens.size()){
                ans = Math.max(ans, odds.get(i) + evens.get(cnt - i));
            }
        }
        return ans;
    }

}

