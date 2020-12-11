package us.supercheng.algorithm.problems.leetcode.teemoattacking;

class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length < 1)
            return 0;

        int retVal = 0;

        for (int i=0;i<timeSeries.length;i++) {
            int next = timeSeries[i] + duration;
            retVal += next - timeSeries[i];
            for (;i+1 <timeSeries.length && timeSeries[i+1] < next;i++) {
                int curr = next;
                next = next + (timeSeries[i+1] + duration - next);
                retVal += next - curr;
            }
        }

        return retVal;
    }
}