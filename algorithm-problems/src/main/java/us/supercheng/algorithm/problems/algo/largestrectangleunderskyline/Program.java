package us.supercheng.algorithm.problems.algo.largestrectangleunderskyline;

import java.util.*;

public class Program {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1,3,3,2,4,1,5,3,2});

        int res = new Program().largestRectangleUnderSkyline(new ArrayList<>(list));
        System.out.println("res: " + res);

    }

    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        int ret = 0;
        int len = buildings.size();
        int[][] minHeight = new int[len][len];

        for (int i=0; i<len; i++) {
            minHeight[i][i] = buildings.get(i);
            for (int j=i+1; j<len; j++)
                minHeight[i][j] = Math.min(minHeight[i][j - 1], buildings.get(j));
        }

        for (int i=0; i<len; i++)
            for (int j=i; j<len; j++)
                ret = Math.max(minHeight[i][j] * (j - i + 1), ret);

        return ret;
    }

}
