class Solution:
    def specialArray(self, nums: List[int]) -> int:
        bucket = istofzeros = [0] * 1001

        for n in nums:
            bucket[n] += 1

        for idx in range(1, len(nums) + 1):
            if self.countIt(nums, bucket, idx) == idx:
                return idx

        return -1


    def countIt(self, nums: List[int], bucket: List[int], val: int) -> int:
        ret = 0

        for v in range(val, 1001):
            ret += bucket[v]
            if ret > val:
                return -1

        return ret if ret == val else -1
