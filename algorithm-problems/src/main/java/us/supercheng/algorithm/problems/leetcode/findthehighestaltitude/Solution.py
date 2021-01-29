class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        ret = 0
        curr = 0

        for g in gain:
            curr += g
            ret = max(curr, ret)

        return ret