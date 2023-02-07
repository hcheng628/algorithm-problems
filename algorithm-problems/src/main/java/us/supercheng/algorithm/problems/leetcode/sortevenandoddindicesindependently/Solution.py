class Solution(object):
    def sortEvenOdd(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        count = {}

        for i in range(0, len(nums), 2):
            count[nums[i]] = count[nums[i]] + 1 if nums[i] in count else 1

        idx = 0
        for i in range(1, 101):
            while i in count and count[i] > 0:
                count[i] -= 1
                nums[idx] = i
                idx += 2

        for i in range(1, len(nums), 2):
            count[nums[i]] = count[nums[i]] + 1 if nums[i] in count else 1

        idx = 1
        for i in range(100, -1, -1):
            while i in count and count[i] > 0:
                count[i] -= 1
                nums[idx] = i
                idx += 2

        return nums
