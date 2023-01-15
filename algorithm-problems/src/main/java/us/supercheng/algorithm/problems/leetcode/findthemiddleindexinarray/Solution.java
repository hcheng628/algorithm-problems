package us.supercheng.algorithm.problems.leetcode.findthemiddleindexinarray;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class Solution {

    public int findMiddleIndex(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        int total = IntStream.of(nums).boxed().
                collect(Collectors.toCollection(ArrayList::new)).
                stream().mapToInt(a -> a).sum();

        for (int leftSum = 0, rightSum = total, i = 0, len = nums.length; i < len; i++) {
            if (leftSum == rightSum - nums[i])
                return i;

            leftSum += nums[i];
            rightSum -= nums[i];
        }

        return -1;
    }

}
