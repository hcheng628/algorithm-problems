package us.supercheng.algorithm.problems.algo.squareofzeroes;

import java.util.*;

public class Program {

    // Time: (n^4) Space: (1)
    public static boolean squareOfZeroes_Solution1(List<List<Integer>> matrix) {
        for (int i=0, size = matrix.size(); i<size; i++)
            for (int j=0; j<size; j++)
                if (matrix.get(i).get(j) == 0)
                    if (checkSQ(matrix, i, j, size))
                        return true;
        return false;
    }

    private static boolean checkSQ(List<List<Integer>> mat, int row, int col, int size) {
        for (int len=1; len<=size; len++) {
            int newRow = row + len;
            int newCol = col + len;
            boolean isPerfect = true;

            if (newRow >= size || newCol >= size)
                return false;

            for (int i=0;isPerfect && i<=len; i++)
                if ((mat.get(row).get(col + i) == 1 || mat.get(newRow).get(col + i) == 1) ||
                        (mat.get(row + i).get(col) == 1 || mat.get(row + i).get(newCol) == 1))
                    isPerfect = false;

            if (isPerfect)
                return true;
        }

        return false;
    }



    // Time: (n^3) Space: (n^2)
    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        Info[][] infos = getMatInfo(matrix);
        for (int i=0, size = matrix.size(); i<size; i++)
            for (int j=0; j<size; j++)
                if (matrix.get(i).get(j) == 0)
                    if (checkSQ(infos, i, j, size))
                        return true;
        return false;
    }

    private static Info[][] getMatInfo(List<List<Integer>> mat) {
        int rlen = mat.size();
        int cLen = mat.get(0).size();
        Info[][] ret = new Info[rlen][cLen];

        ret[rlen- 1][cLen - 1] = mat.get(rlen - 1).get(cLen - 1) == 0 ? new Info(1, 1) : new Info();
        for (int col=cLen-2; col>-1; col--)
            ret[rlen - 1][col] = mat.get(rlen - 1).get(col) == 0 ? new Info(ret[rlen - 1][col + 1].right + 1, 1) : new Info();

        for (int row=rlen-2; row>-1; row--)
            for (int col=cLen-1; col >-1; col--)
                if (col == cLen - 1)
                    ret[row][col] = mat.get(row).get(col) == 0 ? new Info(1, 1 + ret[row + 1][col].bottom) : new Info();
                else
                    ret[row][col] = mat.get(row).get(col) == 0 ? new Info(1 + ret[row][col + 1].right, 1 + ret[row + 1][col].bottom) : new Info();

        return ret;
    }

    private static boolean checkSQ(Info[][] infos, int row, int col, int size) {
        for (int len=1; len<=size; len++) {
            int right = col + len;
            int bot = row + len;
            int width = len + 1;

            if (bot >= infos.length || right >= infos[0].length)
                return false;

            Info topLeft = infos[row][col];
            Info topRight = infos[row][right];
            Info botLeft = infos[bot][col];

            if (topLeft.right >= width && botLeft.right >= width && topLeft.bottom >= width && topRight.bottom >= width)
                return true;
        }

        return false;
    }

    static class Info {
        int right;
        int bottom;

        public Info() {
            this.right = 0;
            this.bottom = 0;
        }

        public Info(int r, int b) {
            this.right = r;
            this.bottom = b;
        }

        public String toString() {
            return "[ right:" + right + ", bottom: " + bottom + "]";
        }
    }

}