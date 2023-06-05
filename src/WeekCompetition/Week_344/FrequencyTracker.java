package WeekCompetition.Week_344;

import java.util.*;

public class FrequencyTracker {

    int[] freq;
    int[] rfreq;

    public FrequencyTracker() {
        freq = new int[100001];
        rfreq = new int[200002];
    }

    public void add(int number) {
        if(freq[number] > 0) rfreq[freq[number]]--;
        freq[number]++;
        rfreq[freq[number]]++;
    }

    public void deleteOne(int number) {
        if(freq[number] > 0) {
            rfreq[freq[number]]--;
            freq[number]--;
            rfreq[freq[number]]++;
        }

    }

    public boolean hasFrequency(int frequency) {
        return rfreq[frequency] > 0;
    }
}
