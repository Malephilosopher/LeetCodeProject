package April.Day9;

import java.util.*;

public class TopVotedCandidate {


    List<Integer> tops;
    Map<Integer, Integer> voteCounts;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        tops = new ArrayList<Integer>();
        voteCounts = new HashMap<Integer, Integer>();
        voteCounts.put(-1, -1);
        int top = -1;
        for (int i = 0; i < persons.length; ++i) {
            int p = persons[i];
            voteCounts.put(p, voteCounts.getOrDefault(p, 0) + 1);
            if (voteCounts.get(p) >= voteCounts.get(top)) {
                top = p;
            }
            tops.add(top);
        }
        this.times = times;
    }

    public int q(int t) {
        int l = 0, r = times.length - 1;
        // 找到满足 times[l] <= t 的最大的 l
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (times[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return tops.get(l);
    }


    public static void main(String[] args) {
        int[] persons = {0,1,0,1,1};
        int[] times = {24,29,31,76,81};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
        System.out.println(topVotedCandidate.q(28));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(29));
        System.out.println(topVotedCandidate.q(77));
        System.out.println(topVotedCandidate.q(30));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(76));
        System.out.println(topVotedCandidate.q(75));
        System.out.println(topVotedCandidate.q(81));
        System.out.println(topVotedCandidate.q(80));
    }
}
