class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        ret = 0
        m = {}

        for i in range(highLimit - lowLimit + 1):
            idx = self.get_idx(lowLimit + i)
            if idx in m:
                m[idx] += 1
            else:
                m[idx] = 1
            ret = max(m[idx], ret)

        return ret


    def get_idx(self, num):
        ret = 0
        while num != 0:
            ret += num % 10
            num //= 10
        return ret
