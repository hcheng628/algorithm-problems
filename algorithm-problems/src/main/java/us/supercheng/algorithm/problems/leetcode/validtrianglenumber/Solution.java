package us.supercheng.algorithm.problems.leetcode.validtrianglenumber;

import java.util.Arrays;

class Solution {

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        int len = nums.length,
                ret = 0;
        Arrays.sort(nums);

        for (int min=0;min<len-2;min++)
            if (nums[min] > 0)
                for (int mid=min+1;mid<len-1;mid++)
                    for (int max=len-1, minLen=nums[min]+nums[mid];max > mid;) {
                        if (minLen > nums[max]) {
                            ret += max - mid;
                            break;
                        } else
                            max--;
                    }

        return ret;
    }

    public int triangleNumber1(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        int len = nums.length,
                ret = 0;
        Arrays.sort(nums);

        for (int min=0;min<len-2;min++)
            if (nums[min] > 0) {
                int max = min + 2;
                for (int mid=min+1; mid<len-1;mid++) {
                    max = this.bSearch(nums, max, len-1, nums[min] + nums[mid]);
                    ret += max - mid - 1;
                }
            }

        return ret;
    }

    private int bSearch(int[] nums, int left, int right, int key) {
        while (left <= right && right < nums.length) {
            int mid = (left + right) / 2;
            if (nums[mid] >= key)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public int triangleNumber2(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        int ret = 0,
                len = nums.length;

        for (int a=0;a<len;a++)
            for (int b=a+1;b<len;b++)
                for (int c=b+1;c<len;c++) {
                    int max = Math.max(nums[a], Math.max(nums[b], nums[c])),
                            min = Math.max(nums[a], Math.max(nums[b], nums[c])),
                            mid = nums[a] + nums[b] + nums[c] - max - min;
                    if (this.isT(max, mid, min))
                        ret++;
                }

        return ret;
    }

    private boolean isT(int a, int b, int c) {
        return a+b>c && a+c>b && b+c>a;
    }
}