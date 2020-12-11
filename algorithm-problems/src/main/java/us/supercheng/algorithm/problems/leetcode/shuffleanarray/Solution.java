package us.supercheng.algorithm.problems.leetcode.shuffleanarray;

import java.util.Arrays;
import java.util.Random;

class Solution {

    int[] backup;
    int[] shuffle;
    Random rand;

    public Solution(int[] nums) {
        this.backup = nums;
        this.shuffle = Arrays.copyOf(nums, nums.length);
        this.rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.backup;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        this.shuffle = Arrays.copyOf(this.backup, this.backup.length);
        for (int i=0;i<this.backup.length;i++) {
            int j = this.rand.nextInt(i+1);
            if (i != j)
                this.swap(i,j);
        }
        return this.shuffle;
    }

    private void swap(int x, int y) {
        int temp = this.shuffle[x];
        this.shuffle[x] = this.shuffle[y];
        this.shuffle[y] = temp;
    }
}