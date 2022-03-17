package leetcode.BinaryTree.SearchMatrix;

/*
0ms 100.00%
37.8MB 84.06%
 */
public class SMPer {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = -1, col = -1;
        if(m != 1)
        {
            for (int i = 0; i < m - 1; i++) {
                if(target >= matrix[i][0])
                {
                    if(target < matrix[i + 1][0])
                    {
                        row = i;
                    }else {
                        row = i + 1;
                    }
                }
            }
        }else {
            row = 0;
        }
        if(row == - 1) return false;
        for (int i = 0; i < n; i++) {
            if(target == matrix[row][i])
            {
                col = i;
            }
        }
        return col != -1;



    }
}
