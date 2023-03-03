class Solution(object):
    def differenceOfSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0

        for n in nums:
            ret += n
            while n != 0:
                ret -= n % 10
                n //= 10

        return ret
