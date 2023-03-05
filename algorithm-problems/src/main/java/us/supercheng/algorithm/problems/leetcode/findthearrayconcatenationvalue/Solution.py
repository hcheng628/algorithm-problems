class Solution(object):
    def findTheArrayConcVal(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0
        left, right = 0, len(nums) - 1

        while left <= right:
            if left == right:
                ret += nums[left]
            else:
                ret += int("".join([str(nums[left]), str(nums[right])]))
                right -= 1
            left += 1

        return ret
