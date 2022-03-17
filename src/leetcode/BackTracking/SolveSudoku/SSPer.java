package leetcode.BackTracking.SolveSudoku;

import java.util.ArrayList;
import java.util.List;

public class SSPer {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if(isValid(board, i, j, k)){
                        board[i][j] = k;
                        if(backtracking(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char val){
        //检查行
        for (int i = 0; i < 9; i++) {
            char cur = board[row][i];
            if(cur == val) return false;
        }

        //检查列
        for (int i = 0; i < 9; i++) {
            char cur = board[i][col];
            if(cur == val) return false;
        }

        //检查宫
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}