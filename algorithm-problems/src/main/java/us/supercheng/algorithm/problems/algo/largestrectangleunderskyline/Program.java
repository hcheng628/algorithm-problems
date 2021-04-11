package us.supercheng.algorithm.problems.algo.largestrectangleunderskyline;

import java.util.*;

public class Program {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1,3,3,2,4,1,5,3,2});
        int res = new Program().largestRectangleUnderSkyline_Solution1(new ArrayList<>(list));
        System.out.println("res: " + res);
    }

    public int largestRectangleUnderSkyline_Solution1(ArrayList<Integer> buildings) {
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

    // Time: O(n^2) Space: O(1)
    public int largestRectangleUnderSkyline_Solution2(ArrayList<Integer> buildings) {
        int ret = 0;

        for (int i=0, size=buildings.size(); i<size; i++) {
            int res = this.calArea(buildings, size, i);
            if (ret < res)
                ret = res;
        }

        return ret;
    }

    private int calArea(ArrayList<Integer> buildings, int size, int i) {
        int height = buildings.get(i);
        int ret = height;

        for (int left=i-1, right=i+1; left>-1 || right<size; left--, right++) {
            if (left > -1) {
                if (buildings.get(left) >= height)
                    ret += height;
                else
                    left = -1;
            }

            if (right < size) {
                if (buildings.get(right) >= height)
                    ret += height;
                else
                    right = size;
            }
        }

        return ret;
    }

    // Time: O(n) Space: O(n)
    public int largestRectangleUnderSkyline_Solution3(ArrayList<Integer> buildings) {
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        buildings.add(0);

        for (int i=0, size=buildings.size(); i<size; i++) {
            while (!stack.isEmpty() && buildings.get(i) <= buildings.get(stack.peek())) {
                int idx = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                ret = Math.max(width * buildings.get(idx), ret);
            }
            stack.add(i);
        }

        return ret;
    }

}
