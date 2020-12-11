package us.supercheng.algorithm.problems.leetcode.findwinneronatictactoegame;

import java.util.Arrays;

public class Solution {

    char[][] mat;

    public String tictactoe(int[][] moves) {
        this.mat = new char[3][3];
        for (char[] row : this.mat)
            Arrays.fill(row, ' ');

        for (int i=0,len=moves.length;i<len;i++)
            if (i % 2 == 0) {
                this.mat[moves[i][0]][moves[i][1]] = 'X';
                if (this.hasWin('X'))
                    return "A";
            } else {
                this.mat[moves[i][0]][moves[i][1]] = 'O';
                if (this.hasWin('O'))
                    return "B";
            }

        return this.hasEmpty() ? "Pending" : "Draw";
    }

    private boolean hasWin(char c) {
        return this.mat[0][0] == c && this.mat[0][1] == c && this.mat[0][2] == c ||
                this.mat[1][0] == c && this.mat[1][1] == c && this.mat[1][2] == c ||
                this.mat[2][0] == c && this.mat[2][1] == c && this.mat[2][2] == c ||
                this.mat[0][0] == c && this.mat[1][0] == c && this.mat[2][0] == c ||
                this.mat[0][1] == c && this.mat[1][1] == c && this.mat[2][1] == c ||
                this.mat[0][2] == c && this.mat[1][2] == c && this.mat[2][2] == c ||
                this.mat[0][0] == c && this.mat[1][1] == c && this.mat[2][2] == c ||
                this.mat[0][2] == c && this.mat[1][1] == c && this.mat[2][0] == c;
    }

    private boolean hasEmpty() {
        for (char[] row : this.mat)
            for (char col : row)
                if (col == ' ')
                    return true;
        return false;
    }
}