package WeekCompetition.Week_341;

public class P1 {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int res = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += mat[i][j];
            }
            if(cnt > max){
                res = i;
                max = cnt;
            }
        }

        return new int[]{res, max};

    }
}
