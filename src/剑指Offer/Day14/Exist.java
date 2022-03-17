package 剑指Offer.Day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exist {

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        if(" ".equals(word)) return false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, String w, int x, int y, int index){
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        if(board[x][y] != w.charAt(index)) return false;
        if(index + 1 == w.length()){
            return true;
        }
        board[x][y] = '\0';
        boolean found = false;
        for (int[] dir: dirs) {
            int x1 = dir[0] + x;
            int y1 = dir[1] + y;
            if(dfs(board, w, x1, y1, index + 1)) {
                found = true;
                break;
            }
        }
        board[x][y] = w.charAt(index);
        return found;
    }

    public static void main(String[] args) {
        Exist er = new Exist();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(er.exist(board, "ABCCED"));
    }
}
