class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        ret = 0
        length = len(nums)

        for i in range(1, length):
            for j in range (i):
                if nums[i] == nums[j]:
                    ret += 1

        return ret

    def numIdenticalPairs(self, nums: List[int]) -> int:
        bucket = [nums.count(n) - 1 for n in nums]
        return sum(bucket) // 2
