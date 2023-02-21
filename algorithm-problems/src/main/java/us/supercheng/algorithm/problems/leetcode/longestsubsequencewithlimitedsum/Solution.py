class Solution(object):
    def answerQueries(self, nums, queries):
        """
        :type nums: List[int]
        :type queries: List[int]
        :rtype: List[int]
        """
        ret = []
        nums.sort()

        for i in range(1, len(nums)):
            nums[i] += nums[i - 1]

        for q in queries:
            ret.append(bisect_right(nums, q))

        return ret
