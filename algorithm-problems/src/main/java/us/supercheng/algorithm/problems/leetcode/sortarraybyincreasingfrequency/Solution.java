package us.supercheng.algorithm.problems.leetcode.sortarraybyincreasingfrequency;

public class Solution {
    public int[] frequencySort(int[] nums) {
        int max = 0;
        int[] bucket= new int[201],
              ret = new int[nums.length];

        for (int n : nums) {
            int idx = n + 100;
            bucket[idx]++;
            if (bucket[idx] > max)
                max = bucket[idx];
        }

        for (int idx=0, curr = 1; curr <= max; curr++)
            for (int i=200; i>-1; i--)
                if (bucket[i] == curr)
                    for (int j=0; j<curr; j++)
                        ret[idx++] = i - 100;

        return ret;
    }
}