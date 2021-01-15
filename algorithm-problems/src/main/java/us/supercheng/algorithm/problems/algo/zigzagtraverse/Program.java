package us.supercheng.algorithm.problems.algo.zigzagtraverse;

import java.util.*;

public class Program {

    public static List<Integer> zigzagTraverse_Solution1(List<List<Integer>> array) {
        return helper(new ArrayList<>(), array, 0, 0, array.size(), array.get(0).size(), false);
    }

    public static List<Integer> helper(List<Integer> ret, List<List<Integer>> array, int x, int y, int R, int C, boolean isUp) {
        if (ret.size() == R * C)
            return ret;

        if (x < 0 || y < 0 || x >= R || y >= C)
            isUp = !isUp;

        if (y >= C) {
            x += 2;
            y = C - 1;
        } else if (x >= R) {
            x = x - 1;
            y = y + 2;
        } else if (x < 0)
            x = 0;
        else if (y < 0)
            y = 0;

        ret.add(array.get(x).get(y));

        return isUp ? helper(ret, array, x - 1, y + 1, R, C, isUp) :
                helper(ret, array, x + 1, y - 1, R, C, isUp);
    }

    public static List<Integer> zigzagTraverse_Solution2(List<List<Integer>> array) {
        List<Integer> ret = new ArrayList<>();

        int R = array.size();
        int C = array.get(0).size();
        boolean downward = true;

        for (int r=0, c=0, total=R*C; ret.size() != total; ) {
            if (r >= 0 && c >=0 && r < R && c < C) {
                ret.add(array.get(r).get(c));
                r = downward ? r + 1 : r - 1;
                c = downward ? c - 1 : c + 1;
            } else {
                if (downward) {
                    if (r >= R && c < 0) {
                        r = R - 1;
                        c += 2;
                    } else if (r >= R) {
                        r = R - 1;
                        c += 2;
                    } else if (c < 0)
                        c = 0;
                } else {
                    if (r < 0 && c >= C) {
                        r = 1;
                        c = C - 1;
                    } else if (c >= C) {
                        r += 2;
                        c = C - 1;
                    } else if (r < 0)
                        r = 0;
                }
                downward = !downward;
            }
        }

        return ret;
    }

}
