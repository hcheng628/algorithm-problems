class Solution(object):
    def countElements(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) < 3:
            return 0

        ret = 0
        min_val = nums[0]
        max_val = nums[0]

        for n in nums:
            min_val = min(min_val, n)
            max_val = max(max_val, n)

        for n in nums:
            if min_val < n < max_val:
                ret += 1

        return ret

    def countElements_math(self, nums):
        if nums is None or len(nums) < 3:
            return 0

        ret = len(nums) - (nums.count(max(nums)) + nums.count(min(nums)))
        return 0 if ret < 0 else ret
