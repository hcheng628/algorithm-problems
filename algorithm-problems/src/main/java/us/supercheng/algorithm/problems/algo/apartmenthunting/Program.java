package us.supercheng.algorithm.problems.algo.apartmenthunting;

import java.util.*;

public class Program {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        return method_2(blocks, reqs);
    }

    // Time: O(b*b*r) Space: O(r)
    private static int method_1(List<Map<String, Boolean>> blocks, String[] reqs) {
        int ret = -1;

        for (int currBest = -1, i=0, len = blocks.size(); i<len; i++) {
            Map<String, Integer> res = findReqs(blocks, reqs, i);
            if (res.size() == reqs.length) {
                int max = -1;
                for (Map.Entry<String, Integer> entry : res.entrySet())
                    max = Math.max(entry.getValue(), max);

                if (currBest == -1 || max < currBest) {
                    currBest = max;
                    ret = i;
                }
            }
        }

        return ret;
    }

    private static Map<String, Integer> findReqs(List<Map<String, Boolean>> blocks, String[] reqs, int idx) {
        Map<String, Integer> ret = new HashMap<>();

        for (String req : reqs) {
            int dis = -1;
            for (int i=0, len=blocks.size(); i<len; i++) {
                Boolean hasIt = blocks.get(i).get(req);
                if (hasIt != null && hasIt && (dis == -1 || Math.abs(i - idx) < dis))
                    dis = Math.abs(i - idx);
            }

            if (dis != -1)
                ret.put(req, dis);
        }

        return ret;
    }

    // Time: O(b*r) Space: O(b*r)
    private static int method_2(List<Map<String, Boolean>> blocks, String[] reqs) {
        int bLen = blocks.size();
        int ret = -1;

        Map<String, int[]> disMap = new HashMap<>();

        for (String req : reqs) {
            int[] distance = new int[bLen];
            Arrays.fill(distance, Integer.MAX_VALUE);
            disMap.put(req, distance);

            for (int i=0, best = Integer.MAX_VALUE; i<bLen; i++) {
                Boolean hasIt = blocks.get(i).get(req);
                if (hasIt != null && hasIt) {
                    distance[i] = 0;
                    best = i;
                } else
                    if (best != Integer.MAX_VALUE)
                        distance[i] = i - best;
            }

            for (int i=bLen-1, best = Integer.MAX_VALUE; i>-1; i--) {
                if (distance[i] == 0) {
                    best = i;
                    continue;
                }
                if (best != Integer.MAX_VALUE && best - i < distance[i])
                    distance[i] = best - i;
            }
        }

        for (int i=0, currBest = -1; i<bLen; i++) {
            int max = -1;
            for (Map.Entry<String, int[]> entry : disMap.entrySet())
                max = Math.max(entry.getValue()[i], max);

            if (max != -1 && (currBest == -1 || max < currBest)) {
                currBest = max;
                ret = i;
            }
        }

        return ret;
    }
}
