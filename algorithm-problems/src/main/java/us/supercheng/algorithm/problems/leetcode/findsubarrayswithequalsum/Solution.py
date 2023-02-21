class Solution(object):
    def findSubarrays(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        unique = set()
        for i in range(1, len(nums)):
            if nums[i - 1] + nums[i] in unique:
                return True
            unique.add(nums[i - 1] + nums[i])
        return False
