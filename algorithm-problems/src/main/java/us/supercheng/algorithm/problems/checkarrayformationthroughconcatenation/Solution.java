package us.supercheng.algorithm.problems.checkarrayformationthroughconcatenation;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int[] p : pieces)
            map.put(p[0], p);

        for (int i=0, len = arr.length; i<len;) {
            int[] p = map.get(arr[i]);
            if (p == null)
                return false;

            for (int j=0; j<p.length && i<len;j++) {
                if (p[j] == arr[i])
                    i++;
                else
                    return false;
            }
        }

        return true;
    }
}