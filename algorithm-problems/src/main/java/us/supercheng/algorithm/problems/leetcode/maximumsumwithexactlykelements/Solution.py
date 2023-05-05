class Solution:
    def maximizeSum(self, nums: List[int], k: int) -> int:
        return 0 if not k or k < 1 else (max(nums) * 2 + k - 1) * k // 2
