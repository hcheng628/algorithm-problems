class Solution:
    def beautifulArray(self, N: int) -> List[int]:
        ret = [1]

        while len(ret) != N:
            left = []
            right = []
            for a in ret:
                res = a * 2
                if res <= N:
                    left.append(res)
                if res - 1 <= N:
                    right.append(res-1)

            ret = left + right

        return ret