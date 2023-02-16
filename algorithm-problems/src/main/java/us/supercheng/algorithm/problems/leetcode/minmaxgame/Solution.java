package us.supercheng.algorithm.problems.leetcode.minmaxgame;

class Solution {

    public int minMaxGame(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.min(nums[0], nums[1]);

        int half = nums.length / 2;
        int[] arr = new int[half];

        for (int i = 0, idx = 0; i < half - 1; i += 2, idx++) {
            int rightIdx = idx + (half / 2);
            arr[idx] = idx % 2 == 0 ? Math.min(nums[i], nums[i + 1]) : Math.max(nums[i], nums[i + 1]);
            arr[rightIdx] = rightIdx % 2 == 0 ? Math.min(nums[i + half], nums[i + half + 1]) : Math.max(nums[i + half], nums[i + half + 1]);
        }

        return this.minMaxGame(arr);
    }

}
