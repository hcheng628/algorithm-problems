package us.supercheng.algorithm.problems.howmanynumbersaresmallerthanthecurrentnumber;

import java.util.Arrays;

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len],
              sortedNums = Arrays.copyOf(nums, len);

        Arrays.sort(sortedNums);

        for (int i=0 ;i<len; i++) {
            int idx = Arrays.binarySearch(sortedNums, nums[i]);

            while (idx > 0 && sortedNums[idx-1] == sortedNums[idx])
                idx--;

            ret[i] = idx;
        }

        return ret;
    }
}
