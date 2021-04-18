class Solution:
    def minOperations(self, nums: List[int]) -> int:
        ret = 0

        for i in range(1, len(nums)):
            if nums[i - 1] >= nums[i]:
                increase = nums[i - 1] - nums[i] + 1
                nums[i] += increase
                ret += increase

        return ret
