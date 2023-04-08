package 网易笔试;


import java.util.*;

/**
 *
 */
public class P3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        String[] line2 = sc.nextLine().split(" ");
        List<Long> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            values.add(Long.parseLong(line2[i]));
        }
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            edges.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
        }

        List<Integer> edgeValue = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] edge = edges.get(i);
            int val = Long.numberOfTrailingZeros(values.get(edge[0] + 1) * values.get(edge[1] + 1));
            edgeValue.add(val);
        }

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int nodesTraveled = 1;
            for (int j = 0; j < m; j++) {
                int[] edge = edges.get(j);
                int n1 = edge[0];
                int n2 = edge[1];

            }
        }


    }

}
