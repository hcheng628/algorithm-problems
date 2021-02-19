package us.supercheng.algorithm.problems.algo.diskstacking;

import java.util.*;

public class Program {

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        Collections.sort(disks, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return getHeight(o1) - getHeight(o2);
            }
        });

        int len = disks.size();
        int[] dp = new int[len];

        for (int i=0; i<len; i++)
            dp[i] = getHeight(disks.get(i));

        int maxIdx = 0;
        int maxVal = dp[0];

        for (int i=1; i<len; i++) {
            for (int j=0; j<i;j++) {
                Integer[] top = disks.get(j);
                Integer[] bot = disks.get(i);
                if (canStack(top, bot))
                    dp[i] = Math.max(dp[i], getHeight(bot) + dp[j]);
            }
            if (dp[i] > maxVal) {
                maxVal = dp[i];
                maxIdx = i;
            }
        }

        return buildRet(disks, dp, maxIdx, maxVal, new ArrayList<>());
    }

    private static List<Integer[]> buildRet(List<Integer[]> disks, int[] dp, int idx, int val, List<Integer[]> ret) {
        for (; idx >= 0; idx--)
            if (dp[idx] == val) {
                Integer[] disk = disks.get(idx);
                ret.add(0, disk);
                val -= getHeight(disk);
            }
        return ret;
    }

    private static boolean canStack(Integer[] top, Integer[] bot) {
        return getHeight(top) < getHeight(bot) &&
                getDepth(top) < getDepth(bot) &&
                getWidth(top) < getWidth(bot);
    }

    private static int getHeight(Integer[] disk) {
        return disk[2];
    }

    private static int getDepth(Integer[] disk) {
        return disk[1];
    }

    private static int getWidth(Integer[] disk) {
        return disk[0];
    }

}

