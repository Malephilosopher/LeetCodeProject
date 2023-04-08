package 力扣杯;

public class P2 {

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int n = cookbooks.length;
        boolean[] avail = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(materials[0] >= cookbooks[i][0] && materials[1] >= cookbooks[i][1] && materials[2] >= cookbooks[i][2] && materials[3] >= cookbooks[i][3] && materials[4] >= cookbooks[i][4]){
                avail[i] = true;
            }
        }

        while (true){
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(avail[i])count++;
            }
            for (int i = 0; i < n; i++) {
                if(avail[i]){

                }
            }
        }

    }

}
