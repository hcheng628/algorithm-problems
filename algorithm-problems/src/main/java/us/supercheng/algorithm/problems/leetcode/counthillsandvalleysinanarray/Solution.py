class Solution(object):
    def countHillValley(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0

        for i in range(1, len(nums) - 1):
            right = i + 1

            while right < len(nums) - 1 and nums[i] == nums[right]:
                right += 1

            if (nums[i - 1] < nums[i] > nums[right]) or (nums[i - 1] > nums[i] < nums[right]):
                ret += 1

            i = right

        return ret
