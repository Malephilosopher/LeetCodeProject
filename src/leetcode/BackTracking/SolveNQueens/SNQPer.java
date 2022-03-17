package leetcode.BackTracking.SolveNQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SNQPer {

    private List<String> chessboard = new ArrayList<>();
    private List<List<String>> ans = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        chessboard.clear();
        for (int i = 0; i < n; i++) {
//            chessboard.add(".".repeat(n));
        }
        backtracking(n, 0);
        return ans;
    }

    public void backtracking(int n, int row){
        if(row == n){
            ans.add(new ArrayList<>(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if(isValid(col, row, n)){
                char[] chars = chessboard.get(row).toCharArray();
                chars[col] = 'Q';
                chessboard.set(row, new String(chars));
                backtracking(n, row + 1);
                chars[col] = '.';
                chessboard.set(row, new String(chars));
            }
        }
    }

    public boolean isValid(int col, int row, int n){
        // 检查列
        for (int i = 0; i < row; i++) { // 这是一个剪枝
            if (chessboard.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查 45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--) {
            if (chessboard.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查 135度角是否有皇后
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
