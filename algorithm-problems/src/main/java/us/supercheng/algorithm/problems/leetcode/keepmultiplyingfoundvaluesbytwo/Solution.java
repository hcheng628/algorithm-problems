package us.supercheng.algorithm.problems.leetcode.keepmultiplyingfoundvaluesbytwo;

class Solution {

    public int findFinalValue(int[] nums, int original) {
        if (nums == null || nums.length < 1)
            return original;

        boolean [] visited = new boolean[1001];
        for (int n : nums)
            visited[n] = true;

        while (original < 1001 && visited[original])
            original *= 2;

        return original;
    }

}