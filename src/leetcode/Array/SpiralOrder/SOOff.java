package leetcode.Array.SpiralOrder;

import java.util.ArrayList;
import java.util.List;

public class SOOff {

     public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> order = new ArrayList<Integer>();
         //边界条件
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
             return order;
         }
         int rows = matrix.length, columns = matrix[0].length;
         boolean[][] visited = new boolean[rows][columns]; //记录是否访问过的数组
         int total = rows * columns; //总步数
         int row = 0, column = 0; //初始化指针
         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //方向矩阵(右， 下， 左， 上)
         int directionIndex = 0;
         for (int i = 0; i < total; i++) {
             order.add(matrix[row][column]);
             visited[row][column] = true;
             int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
             if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                 directionIndex = (directionIndex + 1) % 4;
             }
             row += directions[directionIndex][0]; //每一行的第一个元素控制行
             column += directions[directionIndex][1]; //没一行的第二个元素控制列
         }
         return order;
     }


}
