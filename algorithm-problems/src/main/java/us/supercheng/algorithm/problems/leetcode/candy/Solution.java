package us.supercheng.algorithm.problems.leetcode.candy;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int candy(int[] scores) {
        if (scores.length < 2)
            return 1;
        else if (scores.length < 3)
            return 3;

        int len = scores.length;
        int[] rewards = new int[len];
        List<Integer> bottoms = new ArrayList<>();

        for (int curr = 1; curr < len - 1; curr++)
            if (scores[curr - 1] > scores[curr] && scores[curr] < scores[curr + 1])
                bottoms.add(curr);

        for (int i : bottoms) {
            rewards[i] = 1;
            inc(scores, rewards, i);
        }

        if (scores[0] < scores[1]) {
            rewards[0] = 1;
            inc(scores, rewards, 0);
        }

        if (scores[len-2] > scores[len-1]) {
            rewards[len - 1] = 1;
            inc(scores, rewards, len - 1);
        }

        int ret = 0;
        for (int r : rewards)
            ret += r;

        return ret;
    }

    private void inc(int[] scores, int[] rewards, int idx) {
        int left = idx - 1;
        while (left >= 0 && scores[left] > scores[left+1] && rewards[left] <= rewards[left+1]) {
            rewards[left] = rewards[left + 1] + 1;
            left--;
        }

        int right = idx + 1;
        while (right < scores.length && scores[right - 1] < scores[right] && rewards[right - 1] >= rewards[right]) {
            rewards[right] = rewards[right - 1] + 1;
            right++;
        }
    }
}