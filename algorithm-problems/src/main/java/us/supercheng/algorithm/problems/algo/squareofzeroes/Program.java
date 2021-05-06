package us.supercheng.algorithm.problems.algo.squareofzeroes;

import java.util.*;

public class Program {

    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
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

}
