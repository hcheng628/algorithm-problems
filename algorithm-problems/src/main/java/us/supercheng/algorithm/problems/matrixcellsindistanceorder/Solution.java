package us.supercheng.algorithm.problems.matrixcellsindistanceorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int max = 0,
                idx = 0;
        int [][] mat = new int [R*C][2];
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i=0;i<R;i++)
            for(int j=0;j<C;j++) {
                int dis = Math.abs(r0 - i) + Math.abs(c0 - j);
                if (!map.containsKey(dis))
                    map.put(dis, new ArrayList<int[]>());
                map.get(dis).add(new int[] {i, j});
                if (dis>max)
                    max = dis;
            }

        for (int i=0;i<=max;i++)
            for (int[] each : map.get(i)) {
                mat[idx][0] = each[0];
                mat[idx++][1] = each[1];
            }
        return mat;
    }
}