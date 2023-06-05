package WeekCompetition.Week_344;

public class P3 {

    public int[] colorTheArray(int n, int[][] queries) {
        int len = queries.length;
        int[] answer = new int[len];
        int[] nums = new int[n + 2];
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int index = queries[i][0] + 1, color = queries[i][1];
            if(nums[index] > 0){
                cnt -= (nums[index - 1] == nums[index] ? 1 : 0) + (nums[index + 1] == nums[index] ? 1 : 0);
            }
            nums[index] = color;
            cnt += (nums[index - 1] == nums[index] ? 1 : 0) + (nums[index + 1] == nums[index] ? 1 : 0);
            answer[i] = cnt;
        }
        return answer;

    }

    public static void main(String[] args) {
        P3 p = new P3();
        int n = 4;
        int[][] queries = {{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}};

        System.out.println(p.colorTheArray(n, queries));
    }
}
