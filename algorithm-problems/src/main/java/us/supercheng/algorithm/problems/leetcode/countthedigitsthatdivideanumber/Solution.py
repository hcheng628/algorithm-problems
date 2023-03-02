class Solution:
    def countDigits(self, num: int) -> int:
        ret = 0
        backup = num

        while num != 0:
            if backup % (num % 10) == 0:
                ret += 1
            num //= 10

        return ret
