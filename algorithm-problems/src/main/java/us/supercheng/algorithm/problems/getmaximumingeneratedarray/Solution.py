class Solution:
    def getMaximumGenerated(self, n: int) -> int:
        if n < 1:
            return 0
        elif n < 3:
            return 1

        arr = [0, 1]
        ret = res = idx_a = idx_b = 1

        for i in range(2, n + 1):
            if i % 2 == 0:
                res = arr[idx_a]
                idx_a += 1
            else:
                res = arr[idx_b] + arr[idx_b + 1]
                idx_b += 1

            arr.append(res)
            ret = max(ret, res)

        return ret
