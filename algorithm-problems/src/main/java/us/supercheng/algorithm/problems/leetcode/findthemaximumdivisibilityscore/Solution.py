class Solution:
    def maxDivScore(self, nums: List[int], divisors: List[int]) -> int:
        ret = [divisors[0], 0]

        for d in divisors:
            count = 0
            for n in nums:
                if n % d == 0:
                    count += 1
            if count > ret[1] or (count == ret[1] and d < ret[0]):
                ret = [d, count]

        return ret[0]
