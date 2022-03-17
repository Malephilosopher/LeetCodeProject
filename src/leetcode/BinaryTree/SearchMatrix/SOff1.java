package leetcode.BinaryTree.SearchMatrix;

public class SOff1 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (true){
            int num = matrix[x][y];
            if(num == target){
                return true;
            }else if(num < target){
                if(x == m - 1) return false;
                x++;
            }else {
                if(y == 0) return false;
                y--;
            }
        }
    }
}
