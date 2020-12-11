package us.supercheng.algorithm.problems.leetcode.minesweeper;

class Solution {

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];

        if (board[x][y] == 'M')
            board[x][y] = 'X';
        else {
            int mCount = this.doCount(board, x, y);
            if (mCount == 0) {
                board[x][y] = 'B';
                for (int i=-1;i<2;i++)
                    for (int j=-1;j<2;j++) {
                        if (i == 0 && j == 0)
                            continue;
                        int row = x + i, col = y + j;
                        if (row < 0 || col < 0 || row >= board.length || col >= board[x].length)
                            continue;
                        else if (board[row][col] == 'E')
                            updateBoard(board, new int[]{row, col});
                    }
            } else
                board[x][y] = (char) (mCount + '0');
        }
        return board;
    }

    private int doCount(char[][]board, int x, int y) {
        int count = 0;
        for (int i=-1;i<2;i++)
            for (int j=-1;j<2;j++) {
                if (i == 0 && j == 0)
                    continue;
                int row = x+i, col = y+j;
                if (row < 0 || col < 0 || row >= board.length || col >=board[row].length)
                    continue;
                if (board[row][col] == 'M' || board[row][col] == 'X')
                    count++;
            }
        return count;
    }
}