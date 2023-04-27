class Solution:
    def rowAndMaximumOnes(self, mat: List[List[int]]) -> List[int]:
        ret = [-1, -1]
        for r in range(len(mat)):
            count = collections.Counter(mat[r])[1]
            if count > ret[1]:
                ret = [r, count]
        return ret
