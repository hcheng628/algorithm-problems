class Solution(object):
    def arithmeticTriplets(self, nums, diff):
        """
        :type nums: List[int]
        :type diff: int
        :rtype: int
        """
        ret = 0
        unique = set()
        for n in nums:
            if n - diff in unique and n - (2 * diff) in unique:
                ret += 1
            unique.add(n)

        return ret
