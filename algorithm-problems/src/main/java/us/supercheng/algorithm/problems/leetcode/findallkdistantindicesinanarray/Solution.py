class Solution(object):
    def findKDistantIndices(self, nums, key, k):
        """
        :type nums: List[int]
        :type key: int
        :type k: int
        :rtype: List[int]
        """
        ret = []
        last = 0

        for i in range(len(nums)):
            if nums[i] == key:
                right = min(i + k, len(nums) - 1)
                for idx in range(max(i - k, last), right + 1):
                    ret.append(idx)
                last = right + 1

        return ret
