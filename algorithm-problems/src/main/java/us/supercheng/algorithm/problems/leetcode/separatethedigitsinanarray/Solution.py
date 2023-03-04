class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        return [int(nn) for n in nums for nn in str(n)]
