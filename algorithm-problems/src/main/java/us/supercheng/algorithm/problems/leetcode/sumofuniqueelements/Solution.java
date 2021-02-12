package us.supercheng.algorithm.problems.leetcode.sumofuniqueelements;

public class Solution {

    public int sumOfUnique(int[] nums) {
        int[] bucket = new int[101];
        int ret = 0;

        for (int n : nums)
            bucket[n]++;

        for (int i=1; i<101; i++)
            if (bucket[i] == 1)
                ret += i;

        return ret;
    }

}
