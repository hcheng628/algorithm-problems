class Solution(object):
    def divideArray(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        count = [0] * 501

        for n in nums:
            count[n] += 1

        for i in range(1, 501):
            if count[i] % 2 != 0:
                return False

        return True
