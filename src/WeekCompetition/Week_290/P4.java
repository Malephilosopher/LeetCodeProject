package WeekCompetition.Week_290;

public class P4 {

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int end = 1000000000;
        int[] ans = new int[persons.length];
        for (int[] flower: flowers) {
            int start = flower[0];
            int en = flower[1];
            for (int i = 0; i < persons.length; i++){
                int person = persons[i];
                if(person >= start && person <= en){
                    ans[i]++;
                }
            }
        }

        return ans;
    }
}
