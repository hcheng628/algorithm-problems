package us.supercheng.algorithm.problems.algo.knapsackproblem;

import java.util.*;

public class Program {

    public static List<List<Integer>> knapsackProblem_Solution1(int[][] items, int capacity) {
        int len = items.length;
        int[][] dp = new int[len][capacity + 1];

        for (int c=1; c<=capacity; c++) {
            for (int i=0; i<len; i++) {
                int val = items[i][0];
                int weight = items[i][1];

                if (weight > c) {
                    if (i - 1 > -1)
                        dp[i][c] = dp[i - 1][c];
                } else if (weight == c) {
                    if (i - 1 > -1)
                        dp[i][c] = Math.max(dp[i - 1][c], val);
                    else
                        dp[i][c] = val;
                } else if (weight < c) {
                    if (i - 1 > -1) {
                        int accVal = dp[i - 1][c - weight];
                        dp[i][c] = Math.max(dp[i - 1][c], accVal + val);
                    } else {
                        dp[i][c] = val;
                    }
                }
            }
        }

        return buildRet(dp, items);
    }

    private static List<List<Integer>> buildRet(int[][] dp, int[][] items) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int startX = dp.length - 1;
        int startY = dp[startX].length - 1;
        int val = 0;

        while (dp[startX][startY] != 0) {
            if (dp[startX][startY] != dp[startX][startY - 1]) {
                list.add(startX);
                startY -= items[startX][1];
                startX--;
            } else {
                startX--;
            }
        }

        ret.add(Arrays.asList(val));
        ret.add(list);
        return ret;
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        return helper(items, capacity, 0, 0, new ArrayList<>());
    }

    private static List<List<Integer>> helper(int[][] items, int cap, int idx, int currVal, List<Integer> list) {
        if (idx >= items.length) {
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(Arrays.asList(currVal));
            ret.add(new ArrayList<>(list));
            return ret;
        }

        List<List<Integer>> ret = helper(items, cap, idx + 1, currVal, list);
        if (items[idx][1] <= cap) {
            list.add(idx);
            List<List<Integer>> ans = helper(items, cap - items[idx][1], idx + 1, currVal + items[idx][0], list);
            if (ans.get(0).get(0) > ret.get(0).get(0))
                ret = ans;
            list.remove(list.size() - 1);
        }

        return ret;
    }
}
