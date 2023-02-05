class Solution(object):
    def findFinalValue(self, nums, original):
        """
        :type nums: List[int]
        :type original: int
        :rtype: int
        """
        if nums is not None:
            unique = set(nums)
            while original in unique:
                original *= 2

        return original
