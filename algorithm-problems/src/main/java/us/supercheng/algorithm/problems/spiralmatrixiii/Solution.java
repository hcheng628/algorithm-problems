package us.supercheng.algorithm.problems.spiralmatrixiii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int total = R * C;
        List<int[]> list = new ArrayList<>();
        int[] dir = new int[] {0, 1};
        int[][] ret = new int[total][2];

        for (int steps = 1; list.size() != total;steps++)
            for (int count=0; count<2; count++) {
                for (int s=1; s<=steps; s++) {
                    if (r0 < R && c0 < C && r0 > -1 && c0 > -1)
                        list.add(new int[]{r0, c0});

                    r0 += dir[0];
                    c0 += dir[1];
                }
                this.nextDir(dir);
            }

        for (int i=0; i<total; i++)
            ret[i] = list.get(i);

        return ret;
    }

    private void nextDir(int[] dir) {
        if (dir[0] == 0 && dir[1] == 1) {
            dir[0] = 1;
            dir[1] = 0;
        } else if (dir[0] == 1 && dir[1] == 0) {
            dir[0] = 0;
            dir[1] = -1;
        } else if (dir[0] == 0 && dir[1] == -1) {
            dir[0] = -1;
            dir[1] = 0;
        } else if (dir[0] == -1 && dir[1] == 0) {
            dir[0] = 0;
            dir[1] = 1;
        }
    }
}
