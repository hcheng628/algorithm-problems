package us.supercheng.algorithm.problems.leetcode.validsudoku;

public class App {

    public boolean isValidSudoku(char[][] board) {
        int [][] colDB = new int [10][10];
        int [][] rowDB = new int [10][10];
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++) {
                if(i % 3 == 1 && j % 3 == 1 && !check3By3(board, i, j)) // check 3*3
                    return false;
                if(board[i][j] != '.') { // check col + row
                    if(colDB[j][board[i][j] - '0'] > 0 || rowDB[i][board[i][j]- '0'] > 0)
                        return false;
                    colDB[j][board[i][j] - '0']++;
                    rowDB[i][board[i][j] - '0']++;
                }
            }
        return true;
    }

    private boolean check3By3(char[][] board, int i, int j) {
        int [] db = new int [10];
        if(board[i][j] != '.')
            db[board[i][j] - '0']++;
        if(i+1 < 9 && board[i+1][j] != '.') {
            if(db[board[i+1][j] - '0'] > 0)
                return false;
            db[board[i+1][j] - '0']++;
        }
        if(i-1 >= 0 && board[i-1][j] != '.') {
            if(db[board[i-1][j]-'0'] > 0)
                return false;
            db[board[i-1][j]-'0']++;
        }
        if(j+1 < 9 && board[i][j+1] != '.') {
            if(db[board[i][j+1]-'0']>0)
                return false;
            db[board[i][j+1]-'0']++;
        }
        if(j-1>=0 && board[i][j-1] != '.') {
            if(db[board[i][j-1] - '0'] > 0)
                return false;
            db[board[i][j-1] - '0']++;
        }
        if(i+1 < 9 && j+1 < 9 && board[i+1][j+1] != '.') {
            if(db[board[i+1][j+1]-'0'] > 0)
                return false;
            db[board[i+1][j+1]-'0']++;
        }
        if(i-1 >= 0 && j-1 >=0 && board[i-1][j-1] != '.') {
            if(db[board[i-1][j-1]-'0'] > 0)
                return false;
            db[board[i-1][j-1]-'0']++;
        }
        if(i-1 >=0 && j+1 < 9 && board[i-1][j+1] != '.') {
            if(db[board[i-1][j+1]-'0'] > 0)
                return false;
            db[board[i-1][j+1]-'0']++;
        }
        if(i+1 < 9 && j-1 >=0 && board[i+1][j-1] != '.')
            if(db[board[i+1][j-1]-'0'] > 0)
                return false;
        return true;
    }
}
