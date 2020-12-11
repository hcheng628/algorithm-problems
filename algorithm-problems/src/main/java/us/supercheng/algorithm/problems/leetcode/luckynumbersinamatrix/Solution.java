package us.supercheng.algorithm.problems.leetcode.luckynumbersinamatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int len = matrix.length,
                wid = matrix[0].length;
        int[] row = new int[len],
                col = new int[wid];
        List<Integer> ret = new ArrayList<>();

        for (int i=0; i<len; i++) {
            int min = matrix[i][0];
            for (int j=1; j<wid; j++)
                min = Math.min(matrix[i][j], min);
            row[i] = min;
        }

        for (int i=0; i<wid; i++) {
            int max = 0;
            for (int j=0; j<len; j++)
                max = Math.max(matrix[j][i], max);
            col[i] = max;
        }

        for (int i=0;i<len;i++)
            for (int j=0; j<wid; j++)
                if (matrix[i][j] == row[i] && matrix[i][j] == col[j])
                    ret.add(matrix[i][j]);

        return ret;
    }
}