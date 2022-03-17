package leetcode.FindCenter;

public class FPer {

    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        for (int i = 1; i <= n; i++) {
            boolean center = true;
            for (int[] edge: edges) {
                if(edge[0] != i && edge[1] != i){
                    center = false;
                    break;
                }
            }
            if(center) return i;
        }
        return 0;
    }
}
