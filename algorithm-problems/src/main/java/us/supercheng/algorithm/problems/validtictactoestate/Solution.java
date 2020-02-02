package us.supercheng.algorithm.problems.validtictactoestate;

public class Solution {

    public boolean validTicTacToe(String[] board) {
        int totalX = 0,
            totalO = 0;

        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                char c = board[i].charAt(j);
                if (c == 'X')
                    totalX++;
                else if (c == 'O')
                    totalO++;
            }

        if (totalX < totalO || totalX - totalO > 1)
            return false;

        boolean xWin = this.hasWin('X', board),
                oWin = this.hasWin('O', board);

        return !(xWin && oWin || xWin && totalX == totalO || oWin && totalX != totalO);
    }

    private boolean hasWin(char c, String[] board) {
        for (int i=0;i<3;i++)
            if (c == board[i].charAt(0) && c == board[i].charAt(1) && c == board[i].charAt(2))
                return true;

        for (int i=0;i<3;i++)
            if (c == board[0].charAt(i) && c == board[1].charAt(i) && c == board[2].charAt(i))
                return true;

        return c == board[0].charAt(0) && c == board[1].charAt(1) && c == board[2].charAt(2) ||
                c == board[2].charAt(0) && c == board[1].charAt(1) && c == board[0].charAt(2);
    }
}