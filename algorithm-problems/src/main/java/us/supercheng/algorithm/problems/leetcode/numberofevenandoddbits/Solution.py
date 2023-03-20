class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        ret = [0, 0]
        even_idx = True

        while n != 0:
            if (n & 1) == 1:
                ret[0 if even_idx else 1] += 1
            even_idx = not even_idx
            n >>= 1

        return ret
