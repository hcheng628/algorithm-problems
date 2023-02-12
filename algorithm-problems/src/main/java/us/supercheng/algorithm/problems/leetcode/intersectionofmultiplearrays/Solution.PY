class Solution(object):
    def intersectionBK(self, nums):
        """
        :type nums: List[List[int]]
        :rtype: List[int]
        """
        ret = []
        count = [0] * 1001

        for num in nums:
            for n in num:
                count[n] += 1

        for i in range(1, 1001):
            if count[i] == len(nums):
                ret.append(i)

        return ret

    def intersection(self, nums):
        """
        :type nums: List[List[int]]
        :rtype: List[int]
        """
        unique = set(nums[0])

        for num in nums:
            unique = unique.intersection(num)

        return sorted(unique)
