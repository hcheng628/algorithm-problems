package us.supercheng.algorithm.problems.circulararrayloop;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;

        int len = nums.length;

        for (int i=0;i<len;i++)
            if (this.hasLoop(nums, len, i))
                return true;
        return false;
    }

    private boolean hasLoop(int[] nums, int len, int idx) {
        int slow = idx,
                fast = this.getIdx(nums, len, idx),
                dir = nums[idx];

        while (nums[fast] * dir > 0 && nums[this.getIdx(nums, len, fast)] * dir > 0) {
            if (slow == fast) {
                if (slow == this.getIdx(nums, len, slow))
                    break;
                return true;
            }
            slow = this.getIdx(nums, len, slow);
            fast = this.getIdx(nums, len, this.getIdx(nums, len, fast));
        }

        while (nums[idx] * dir > 0) {
            int temp = this.getIdx(nums, len, idx);
            nums[idx] = 0;
            idx=temp;
        }
        return false;
    }

    private int getIdx(int[] nums, int len, int idx) {
        int nextIdx = nums[idx] + idx;
        return nextIdx < 0 ? nextIdx % len + len : nextIdx % len;
    }

    private void echo(Object o) {
        System.out.println(o);
    }
}