package us.supercheng.algorithm.problems.gameoflife;

class Solution {
    public void gameOfLife(int[][] board) {
        int [][] mat = new int [board.length][board[0].length];
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[i].length;j++) {
                int res = this.countLiveCells(i, j, board);
                if ((board[i][j] == 1 && (res == 2 || res == 3)) || (board[i][j] == 0 && res == 3))
                    mat[i][j] = 1;
            }


        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[i].length;j++)
                if (board[i][j] != mat[i][j])
                    board[i][j] = mat[i][j];
    }

    private int countLiveCells(int x, int y, int[][] board) {
        int count = 0;
        if (x - 1 > -1 &&  board[x-1][y] == 1)
            count++;
        if (x+1<board.length && board[x+1][y] == 1)
            count++;
        if (y-1>-1 && board[x][y-1] == 1)
            count++;
        if (y+1<board[x].length && board[x][y+1] == 1)
            count++;
        if (x-1 > -1 && y-1 > -1 && board[x-1][y-1] == 1)
            count++;
        if (x-1 > -1 && y+1<board[x-1].length && board[x-1][y+1] == 1)
            count++;
        if (x+1 < board.length && y-1>-1 && board[x+1][y-1] == 1)
            count++;
        if (x+1<board.length && y+1<board[x+1].length && board[x+1][y+1] == 1)
            count++;
        return count;
    }
}