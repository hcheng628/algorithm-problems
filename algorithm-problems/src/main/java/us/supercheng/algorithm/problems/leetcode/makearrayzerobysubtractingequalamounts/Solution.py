class Solution(object):
    def minimumOperations(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        unique = set(nums)
        return len(unique) - 1 if 0 in unique else len(unique)
