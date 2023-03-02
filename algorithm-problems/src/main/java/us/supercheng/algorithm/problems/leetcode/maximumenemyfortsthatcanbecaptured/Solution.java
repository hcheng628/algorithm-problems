package us.supercheng.algorithm.problems.leetcode.maximumenemyfortsthatcanbecaptured;

class Solution {

    public int captureForts(int[] forts) {
        int ret = 0;

        for (int i = 0, count = 0, prev = 13, len = forts.length; i < len; i++) {
            if (forts[i] == 0)
                count++;
            else {
                if (prev != 13 && prev != forts[i])
                    ret = Math.max(count, ret);
                prev = forts[i];
                count = 0;
            }
        }

        return ret;
    }

}
