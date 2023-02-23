class Solution(object):
    def mostFrequentEven(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        info = [-1, 0]
        count = collections.Counter(nums)

        for idx, val in enumerate(count):
            if val % 2 == 0:
                if count[val] > info[1] or (count[val] == info[1] and val < info[0]):
                    info = [val, count[val]]

        return info[0]
