class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        ret = []
        right_sum = sum(nums)
        left_sum = 0

        for i in range(len(nums) - 1, -1, -1):
            right_sum -= nums[i]
            ret.insert(0, abs(right_sum - left_sum))
            left_sum += nums[i]

        return ret
