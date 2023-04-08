package WeekCompetition.Week_287;

import java.util.*;

public class FindWinners {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer, Integer> lose = new HashMap<>();

        for (int[] match: matches) {
            int winner = match[0];
            int loser = match[1];
            win.put(winner, win.getOrDefault(winner, 0) + 1);
            lose.put(loser, lose.getOrDefault(loser, 0) + 1);
        }
        List<Integer> noLose = new ArrayList<>();
        List<Integer> loseOne = new ArrayList<>();

        for (int key: lose.keySet()) {
            int v = lose.getOrDefault(key, 0);
            if(v == 1){
                loseOne.add(key);
            }
        }

        for (int key: win.keySet()) {
            int v = lose.getOrDefault(key, 0);
            if(v == 0){
                noLose.add(key);
            }
        }
        noLose.sort(Comparator.comparingInt(a -> a));
        loseOne.sort(Comparator.comparingInt(a -> a));

        ans.add(noLose);
        ans.add(loseOne);
        return ans;
    }
}
