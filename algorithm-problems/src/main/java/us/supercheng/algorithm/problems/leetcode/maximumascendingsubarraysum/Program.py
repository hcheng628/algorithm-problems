class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        ret = nums[0]

        for i in range(len(nums) - 1):
            sum = nums[i]
            while i + 1 < len(nums) and nums[i] < nums[i + 1]:
                sum += nums[i + 1]
                i += 1
            ret = max(ret, sum)

        return ret
