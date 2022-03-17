package WeekCompetition.Week_257.NumberOfWeakCharacters;

import java.util.Arrays;
import java.util.Comparator;

public class NOPer {

    public int numberOfWeakCharacters(int[][] properties) {
        int count = 0;
        int n = properties.length;
        Arrays.sort(properties, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int right = -1;
        for (int i = n - 1; i > -1; i --)
        {
            int x = properties[i][0],    y = properties[i][1];
            if (y < right)
                count++;
            right = Math.max(right, y);
        }

        return count;
    }

    public boolean weaker(int[] a, int[] b){
        return a[0] < b[0] && a[1] < b[1];
    }


}
