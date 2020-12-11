package us.supercheng.algorithm.problems.leetcode.nextgreaterelementii;

import java.util.*;

class Solution {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length < 1)
            return nums;
        else if (nums.length == 1)
            return new int[]{-1};

        Stack<Integer> stack = new Stack<>();
        int [] ret = new int [nums.length];
        Arrays.fill(ret, -1);

        for (int i=0;i<nums.length;stack.push(i),i++)
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
                ret[stack.pop()] = nums[i];

        for (int i=0;i<nums.length;i++)
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
                ret[stack.pop()] = nums[i];

        return ret;
    }

}