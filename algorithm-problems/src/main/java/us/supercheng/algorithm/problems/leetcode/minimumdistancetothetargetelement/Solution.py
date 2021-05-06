class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        ret = -1

        for i in range(len(nums)):
            if nums[i] == target and (ret == -1 or abs(i - start) < ret):
                ret = abs(i - start)

        return ret
