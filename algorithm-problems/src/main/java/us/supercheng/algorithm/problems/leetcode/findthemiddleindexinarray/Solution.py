class Solution(object):
    def findMiddleIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        leftVal = 0
        rightVal = sum(nums)

        for i in range(len(nums)):
            currVal = nums[i]
            if leftVal == rightVal - currVal:
                return i
            leftVal += currVal
            rightVal -= currVal

        return -1
