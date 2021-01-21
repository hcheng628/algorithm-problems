class Solution:
    def totalMoney(self, n: int) -> int:
        ret = 0
        base = sum([1,2,3,4,5,6,7])
        amt = n // 7
        days = n % 7

        for i in range(amt):
            ret += base + i * 7

        if days != 0:
            amt += 1

        for i in range(days):
            ret += amt
            amt += 1

        return ret