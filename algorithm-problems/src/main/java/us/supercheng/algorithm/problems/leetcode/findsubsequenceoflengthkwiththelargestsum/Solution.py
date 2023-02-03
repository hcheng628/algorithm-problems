class Solution(object):
    def maxSubsequence(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        idxes = [i for i in range(len(nums))]
        idxes.sort(key=lambda idx: -nums[idx])
        return [nums[idx] for idx in sorted(idxes[:k])]

