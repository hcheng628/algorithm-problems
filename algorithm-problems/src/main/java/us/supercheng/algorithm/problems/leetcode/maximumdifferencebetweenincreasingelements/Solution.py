class Solution(object):
    def maximumDifferenceDP(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = -1
        maxes = [nums[-1]]
        for i in range(len(nums) - 2, -1, -1):
            maxes.insert(0, max(maxes[0], nums[i]))

        for i in range(len(nums) - 1):
            ret = max(maxes[i + 1] - nums[i], ret)

        return -1 if ret < 1 else ret

    def maximumDifference(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = -1
        i = 0

        for j in range(len(nums)):
            if nums[j] - nums[i] > 0:
                ret = max(nums[j] - nums[i], ret)
            else:
                i = j

        return -1 if ret < 1 else ret