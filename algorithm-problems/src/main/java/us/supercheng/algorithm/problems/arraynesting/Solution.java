package us.supercheng.algorithm.problems.arraynesting;

class Solution {

    public int arrayNesting(int[] nums) {
        int count = 0,
                len = nums.length;
        boolean[] visited = new boolean[len];

        for (int i=0;i<len;i++)
            if (!visited[i])
                count = Math.max(this.helper(nums, i, visited, 0, len), count);
        return count;
    }

    private int helper(int[] nums, int idx, boolean[] visited, int count, int len) {
        if (idx >= len || visited[idx])
            return count;
        visited[idx] = true;
        return this.helper(nums, nums[idx], visited, count+1, len);
    }
}