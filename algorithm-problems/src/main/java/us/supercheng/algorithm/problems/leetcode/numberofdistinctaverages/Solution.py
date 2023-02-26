class Solution(object):
    def distinctAverages(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0
        unique = [0] * 201
        nums.sort()

        left = 0
        right = len(nums) - 1

        while left < right:
            unique[nums[left] + nums[right]] += 1
            if unique[nums[left] + nums[right]] == 1:
                ret += 1
            left += 1
            right -= 1

        return ret
