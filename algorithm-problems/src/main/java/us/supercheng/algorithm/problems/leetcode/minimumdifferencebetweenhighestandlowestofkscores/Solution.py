class Solution(object):
    def minimumDifference(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if nums is None or k > len(nums):
            return 0

        nums = sorted(nums)
        ret = nums[k - 1] - nums[0]

        for i in range(k - 1, len(nums)):
            ret = min(nums[i] - nums[i - (k - 1)], ret)

        return ret