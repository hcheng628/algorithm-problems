package us.supercheng.algorithm.problems.fruitintobaskets;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int totalFruitTLE(int[] tree) {
        int ret = 0;

        for (int i=0, len = tree.length; i<len; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int curr = 0;

            for (int idx=i; idx<len; idx++)
                if (map.size() < 2)
                    map.put(tree[idx], map.getOrDefault(tree[idx], 0) + 1);
                else {
                    if (map.containsKey(tree[idx]))
                        map.put(tree[idx], map.get(tree[idx]) + 1);
                    else
                        break;
                }

            for (Map.Entry<Integer, Integer> e : map.entrySet())
                curr += e.getValue();

            ret = Math.max(ret, curr);
        }

        return ret;
    }

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;

        for (int left=0, right=0, len=tree.length; right<len; right++) {
            map.put(tree[right], right);

            for (; map.size() > 2; left++)
                if (map.get(tree[left]) == left)
                    map.remove(tree[left]);

            ret = Math.max(ret, right - left + 1);
        }

        return ret;
    }

    public int totalFruitUpdateMapALot(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 1;

        for (int left=0, right=0, len=tree.length; left<=right && right<len; right++) {
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            for (; map.size() > 2; left++) {
                int count = map.get(tree[left]);
                if (count == 1)
                    map.remove(tree[left]);
                else
                    map.put(tree[left], count-1);
            }
            ret = Math.max(ret, right - left + 1);
        }

        return ret;
    }

    public int totalFruitSW(int[] tree) {
        int ret = 0,
                left = 0,
                len = tree.length;

        for (int i=1, right = -1; i<len; i++)
            if (tree[i] != tree[i-1]) {
                if (right > -1 && tree[i] != tree[right]) {
                    ret = Math.max(ret, i - left);
                    left = right + 1;
                }
                right = i - 1;
            }

        return Math.max(ret, len - left);
    }
}
