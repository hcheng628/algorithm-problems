class Solution(object):
    def findMaxK(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        bucket = [False] * 2001
        ret = -1

        for n in nums:
            bucket[n + 1000] = True
            if n < 0:
                if bucket[abs(n) + 1000] and ret < abs(n):
                    ret = abs(n)
            else:
                if bucket[1000 - n] and ret < n:
                    ret = n

        return ret
