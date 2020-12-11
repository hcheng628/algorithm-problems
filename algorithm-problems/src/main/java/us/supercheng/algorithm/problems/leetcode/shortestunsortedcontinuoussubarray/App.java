package us.supercheng.algorithm.problems.leetcode.shortestunsortedcontinuoussubarray;

import java.util.Arrays;

public class App {

    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = new int [nums.length];
        for(int i=0;i<nums.length;i++)
            sorted[i] = nums[i];
        Arrays.sort(sorted);
        Integer start = null, end = null;
        for(int i=0;i<nums.length;i++) {
            if(sorted[i] != nums[i]) {
                if(start == null)
                    start = i;
                if(start != null)
                    end = i;
            }
        }
        return start == null ? 0 : end - start + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int[] sorted = new int [nums.length];
        for(int i=0;i<nums.length;i++)
            sorted[i] = nums[i];
        Arrays.sort(sorted);
        Integer start = null, end = null;

        for(int left =0; left<nums.length && start == null;left++)
            if(nums[left] != sorted[left])
                start = left;

        for(int right =nums.length-1; right >=0 && end == null;right--)
            if(nums[right] != sorted[right])
                end = right;
        if(start == null)
            return 0;
        return end - start + 1;
    }

    public int findUnsortedSubarray3(int[] nums) {
        int[] sorted = new int [nums.length];
        for(int i=0;i<nums.length;i++)
            sorted[i] = nums[i];
        Arrays.sort(sorted);
        Integer start = null, end = null;
        for(int left=0, right = nums.length -1; (left < nums.length && start == null) || (right >=0 && end == null); left++, right-- ) {
            if(nums[left] != sorted[left] && start == null)
                start = left;
            if(nums[right] != sorted[right] && end == null)
                end = right;
            if(start != null && end != null)
                break;
        }
        return start == null ? 0 : end - start + 1;
    }
}