package us.supercheng.algorithm.problems.battleshipsinaboard;

class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return 0;

        int res = 0;

        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[i].length;j++)
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i-1][j] == 'X' || j > 0 && board[i][j-1] == 'X')
                        continue;
                    res++;
                }

        return res;
    }
}