package us.supercheng.algorithm.problems.leetcode.maximumnumberofballsinabox;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countBalls(int lowLimit, int highLimit) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0, len = highLimit - lowLimit + 1; i<len; i++) {
            int idx = this.getIdx(i + lowLimit);
            map.put(idx, map.getOrDefault(idx, 0) + 1);
            if (map.get(idx) > ret)
                ret = map.get(idx);
        }

        return ret;
    }

    private int getIdx(int num) {
        int ret = 0;
        for (; num > 0; num /= 10)
            ret += num % 10;
        return ret;
    }

}
