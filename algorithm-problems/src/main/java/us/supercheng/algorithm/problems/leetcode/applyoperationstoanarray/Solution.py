class Solution(object):
    def applyOperations(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums) - 1):
            if nums[i] == nums[i + 1]:
                nums[i] <<= 1
                nums[i + 1] = 0

        zero_start = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[zero_start] = nums[i]
                zero_start += 1

        while zero_start < len(nums):
            nums[zero_start] = 0
            zero_start += 1

        return nums
