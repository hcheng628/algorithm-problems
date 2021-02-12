class Solution:
    def sumOfUnique1(self, nums: List[int]) -> int:
        ret = 0
        bucket = [0] * 101

        for n in nums:
            bucket[n] += 1

        for i in range(101):
            if bucket[i] == 1:
               ret += i

        return ret


    def sumOfUnique(self, nums: List[int]) -> int:
        ret = 0
        counter = Counter(nums)

        for c in counter:
            if counter[c] == 1:
                ret += c

        return ret
