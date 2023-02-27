class Solution(object):
    def unequalTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret, left, right = 0, 0, len(nums)

        for idx, key in enumerate(collections.Counter(nums)):
            right -= m[key]
            ret += left * m[key] * right
            left += m[key]

        return ret
