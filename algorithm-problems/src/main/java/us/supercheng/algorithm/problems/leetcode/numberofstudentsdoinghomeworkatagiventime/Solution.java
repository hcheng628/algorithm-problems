package us.supercheng.algorithm.problems.leetcode.numberofstudentsdoinghomeworkatagiventime;

public class Solution {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ret = 0;

        for (int i=0, len=startTime.length; i<len; i++)
            if (queryTime >= startTime[i] && queryTime <= endTime[i])
                ret++;

        return ret;
    }

}
