package us.supercheng.algorithm.problems.algo.nonattackingqueens;

import java.util.*;

public class Program {

    public int nonAttackingQueens(int n) {
        int[][] mat = new int[n][n];
        Set<String> set = new HashSet<>();
        this.helper(mat, 0, 0, set);
        return set.size();
    }

    private void helper(int[][] mat, int curr, int row, Set<String> set) {
        if (row > curr) {
            return;
        }

        if (curr >= mat.length) {
            set.add(this.generateKey(mat));
            return;
        }


        for (int j=0; j<mat[row].length; j++)
            if (this.checkRow(mat, row) && this.checkCol(mat, j) && this.checkDia(mat, row, j)) {
                mat[row][j] = 1;
                this.helper(mat, curr + 1, row + 1, set);
                mat[row][j] = 0;
            }
    }


    private boolean checkRow(int[][] mat, int x) {
        for (int i=0, len=mat[x].length; i<len; i++)
            if (mat[x][i] != 0)
                return false;
        return true;
    }

    private boolean checkCol(int[][] mat, int y) {
        for (int i=0, len=mat.length; i<len; i++)
            if (mat[i][y] != 0)
                return false;
        return true;
    }

    private boolean checkDia(int[][] mat, int x, int y) {
        for (int amt=1; amt<mat.length; amt++)
            if ((x - amt > -1 && y - amt > -1 && mat[x - amt][y - amt] != 0) ||
                    (x + amt < mat.length && y - amt > -1 && mat[x + amt][y - amt] != 0) ||
                    (x + amt < mat.length & y + amt < mat.length && mat[x + amt][y + amt] != 0) ||
                    (x - amt > -1 && y + amt < mat.length && mat[x - amt][y + amt] != 0))
                return false;
        return true;
    }

    private String generateKey(int[][] mat) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<mat.length; i++)
            for (int j=0; j<mat.length; j++)
                if (mat[i][j] == 1)
                    sb.append(i + "," + j + "|");

        return sb.toString();
    }

    private void printMat(int[][] mat) {
        for (int[] r : mat)
            System.out.println(Arrays.toString(r));
        System.out.println();
    }
}
