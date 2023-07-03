class Solution:
    def distinctDifferenceArrayCount(self, nums: List[int]) -> List[int]:
        left = [0] * 51
        right = [0] * 51
        ret = []

        for n in nums:
            right[n] += 1

        for n in nums:
            right[n] -= 1
            left[n] += 1
            ret.append(sum(l > 0 for l in left) - sum(r > 0 for r in right))

        return ret

    def distinctDifferenceArray(self, nums: List[int]) -> List[int]:
        return [len(set(nums[0 : i + 1])) - len(set(nums[i + 1 : len(nums)])) for i in range(len(nums))]
