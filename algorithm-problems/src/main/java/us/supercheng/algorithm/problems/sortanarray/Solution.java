package us.supercheng.algorithm.problems.sortanarray;

public class Solution {

    public int[] sortArray(int[] nums) {
        this.mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2,
            len = right - left + 1,
            l1 = left,
            l2 = mid + 1,
            idx = 0;
        int[] copy = new int[len];

        this.mergeSort(nums, left, mid);
        this.mergeSort(nums, mid+1, right);

        while (l1 <= mid && l2 <= right)
            copy[idx++] = nums[l1] < nums[l2] ? nums[l1++] : nums[l2++];

        while (l1 <= mid)
            copy[idx++] = nums[l1++];

        while (l2 <= right)
            copy[idx++] = nums[l2++];

        for (int i=0; i<len; i++)
            nums[left+i] = copy[i];
    }

}