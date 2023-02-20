class Solution(object):
    def numberOfPairs(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums.sort()
        pairs = 0

        i = 1
        while i < len(nums):
            if (nums[i - 1] == nums[i]):
                pairs += 1
                i += 2
            else:
                i += 1

        return [pairs, len(nums) - (pairs * 2)]
