class Solution(object):
    def averageValue(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        info = [num for num in nums if num % 6 == 0]
        return 0 if len(info) == 0 else sum(info) // len(info)
