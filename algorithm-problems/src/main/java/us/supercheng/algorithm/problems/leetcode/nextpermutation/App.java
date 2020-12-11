package us.supercheng.algorithm.problems.leetcode.nextpermutation;

public class App {

    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>=1;i--)
            if(nums[i-1] < nums[i]) {
                int pos = this.insertPos(nums, i, nums[i-1]);
                int temp = nums[pos];
                nums[pos] = nums[i-1];
                nums[i-1] = temp;
                this.reverse(nums, i, nums.length-1);
                return;
            }
        this.reverse(nums, 0, nums.length-1);
    }

    private void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--]=temp;
        }
    }

    private int insertPos(int[] arr, int left, int val) {
        for(int right = arr.length -1;left<=right;) {
            if(left == right)
                return left;
            int mid = (right - left) / 2 + left;
            if(arr[mid] > val) {
                if(arr[mid+1] <= val)
                    return mid;
                left = mid+1;
            } else
                right = mid-1;
        }
        return -1;
    }
}
