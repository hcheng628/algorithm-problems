package us.supercheng.algorithm.problems.leetcode.minimumnumberofmovestoseateveryone;

import java.util.Arrays;

public class Solution {

    public int minMovesToSeat(int[] seats, int[] students) {
        if (seats == null || students == null || seats.length < 1 || students.length < 1 || seats.length != students.length)
            return -1;

        int ret = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0, len = seats.length; i < len; i++)
            ret += Math.abs(seats[i] - students[i]);

        return ret;
    }

    public int minMovesToSeatOPT(int[] seats, int[] students) {
        if (seats == null || students == null || seats.length < 1 || students.length < 1 || seats.length != students.length)
            return -1;

        int ret = 0;
        int[] counts = new int[101];

        for (int s : seats)
            counts[s]++;
        for (int s : students)
            counts[s]--;

        for (int i = 1; i < 100; i++) {
            ret += Math.abs(counts[i]);
            counts[i + 1] += counts[i];
        }

        return ret;
    }


}
