package us.supercheng.algorithm.problems.leetcode.determinewhethermatrixcanbeobtainedbyrotation;

public class Solution {

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i=0, size=mat.length; i<4; i++) {
            mat = this.rotate(mat, size);
            if (this.isSame(target, mat, size))
                return true;
        }

        return false;
    }

    private int[][] rotate(int[][] mat, int size) {
        int[][] ret = new int[size][size];

        for (int i=0, col=size - 1; i<size; i++,col--)
            for (int j=0; j<size; j++)
                ret[j][col] = mat[i][j];

        return ret;
    }

    private boolean isSame(int[][] a, int[][] b, int size) {
        for (int i=0; i<size; i++)
            for (int j=0; j<size; j++)
                if (a[i][j] != b[i][j])
                    return false;

        return true;
    }
}
