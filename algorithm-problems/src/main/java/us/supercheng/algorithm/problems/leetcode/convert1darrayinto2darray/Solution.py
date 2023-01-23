class Solution(object):
    def construct2DArray(self, original, m, n):
        """
        :type original: List[int]
        :type m: int
        :type n: int
        :rtype: List[List[int]]
        """
        if m * n != len(original):
            return []

        idx = 0
        ret = []

        for i in range(m):
            l = []
            for j in range(n):
                l.append(original[idx])
                idx += 1
            ret.append(l)

        return ret
