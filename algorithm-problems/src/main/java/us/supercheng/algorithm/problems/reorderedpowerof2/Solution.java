package us.supercheng.algorithm.problems.reorderedpowerof2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean reorderedPowerOf2(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;

        for (;N > 0;len++, N /= 10) {
            int res = N % 10;
            map.put(res, map.getOrDefault(res, 0) + 1);
        }

        return this.dfs(map, 0, len, "");
    }


    private boolean dfs(Map<Integer, Integer> map, int curr, int len, String s) {
        if (curr == len)
            return isP2(s);

        for (int key : map.keySet()) {
            if (curr == 0 && key == 0 || map.get(key) <= 0)
                continue;

            map.put(key, map.get(key)-1);
            if (this.dfs(map, curr + 1, len, s + key))
                return true;
            map.put(key, map.get(key)+1);
        }

        return false;
    }

    private boolean isP2(String s) {
        int num = Integer.parseInt(s);
        if (num == 1)
            return true;

        for (int n = 2; n <= num; n*=2)
            if (n == num)
                return true;

        return false;
    }
}