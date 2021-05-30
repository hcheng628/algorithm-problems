class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        return self.helper(nums, 0, len(nums) - 1, 0)

    def helper(self, nums, idx, last, val):
        return val if idx > last else \
            self.helper(nums, idx + 1, last, nums[idx] ^ val) + self.helper(nums, idx + 1, last, val)
