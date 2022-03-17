package Week_259.DetectSquares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/19 11:57
 */
public class DPer {


}

class DetectSquares {

    private List<int[]> list;

    public DetectSquares() {
        list = new ArrayList<>();
    }

    public void add(int[] point) {
        this.list.add(point);
    }

    public int count(int[] point) {
        this.list.add(point);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int[] heights = new int[2];
        if(list.get(0)[0] == list.get(1)[0]){
            heights[0] = list.get(0)[1];
            heights[1] = list.get(1)[1];
        }
        if(list.get(2)[2] == heights[1] && list.get(2)[0] == list.get(3)[0]){

        }
        return 0;
    }
}
