package us.supercheng.algorithm.problems.leetcode.sortevenandoddindicesindependently;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public int[] sortEvenOddBF(int[] nums) {
        int len = nums.length;
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int i = 0; i < len; i += 2) {
            evens.add(nums[i]);
            if (i + 1 < len)
                odds.add(nums[i + 1]);
        }

        Collections.sort(evens);
        Collections.sort(odds);

        for (int i = 0, evenIdx = 0, oddIdx = odds.size() - 1; i < len; i += 2, evenIdx++, oddIdx--) {
            nums[i] = evens.get(evenIdx);
            if (i + 1 < len)
                nums[i + 1] = odds.get(oddIdx);
        }

        return nums;
    }

    public int[] sortEvenOdd(int[] nums) {
        int len = nums.length;
        int[] count = new int[101];

        for (int i = 0; i < len; i += 2)
            count[nums[i]]++;
        for (int n = 1, idx = 0; n < 101; n++)
            for (; count[n] > 0 && idx < len; count[n]--, idx += 2)
                nums[idx] = n;

        for (int i = 1; i < len; i += 2)
            count[nums[i]]++;
        for (int n = 100, idx = 1; n > 0; n--)
            for (; count[n] > 0 && idx < len; count[n]--, idx += 2)
                nums[idx] = n;

        return nums;
    }

}