class Solution:
    def arraySign(self, nums: List[int]) -> int:
        is_negative = False

        for num in nums:
            if num == 0:
                return 0
            elif num < 0:
                is_negative ^= True

        return -1 if is_negative else 1
