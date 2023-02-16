class Solution(object):
    def minMaxGame(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            return min(nums[0], nums[1])

        half = len(nums) // 2
        idx = 0
        ret = [0] * half

        for i in range(0, half, 2):
            right = idx + (half // 2)
            ret[idx] = min(nums[i], nums[i + 1]) if idx % 2 == 0 else max(nums[i], nums[i + 1])
            ret[right] = min(nums[i + half], nums[i + half + 1]) if right % 2 == 0 else max(nums[i + half], nums[i + half + 1])
            idx += 1

        return self.minMaxGame(ret)
