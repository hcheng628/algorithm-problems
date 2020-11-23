class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        L = len(code)
        ret = [0] * L

        if k == 0:
            return ret

        count = abs(k)

        for i in range(L):
            amt = 0
            ii = i
            for j in range(count):
                if k > 0:
                    ii = ii + 1 if ii + 1 < L else 0
                else:
                    ii = ii - 1 if ii - 1 > -1 else L - 1
                amt += code[ii]
            ret[i] = amt

        return ret


    def decrypt2(self, code: List[int], k: int) -> List[int]:
        L = len(code)
        ret = [0] * L

        if k == 0:
            return ret

        ret[0] = sum(code[1: k + 1]) if k > 0 else sum(code[k: L])

        for i in range(1, L):
            if k > 0:
                ret[i] = ret[i-1] + code[(i+k) % L] - code[i]
            else:
                ret[i] = ret[i-1] + code[i-1] - code[(i + k - 1) % L]

        return ret