class Solution(object):
    def countPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        ret = 0
        vals = [[] for i in range(101)]

        for i in range(len(nums)):
            for j in vals[nums[i]]:
                ret += 1 if k == 0 or i * j % k == 0 else 0
            vals[nums[i]].append(i)

        return ret
