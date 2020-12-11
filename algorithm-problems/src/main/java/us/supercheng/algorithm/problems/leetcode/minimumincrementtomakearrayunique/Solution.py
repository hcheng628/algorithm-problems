class Solution:
    def minIncrementForUnique(self, A: List[int]) -> int:
        if A is None or len(A) < 2:
            return 0;

        ret = 0
        A.sort()

        for i in range(1, len(A)):
            if A[i-1] >= A[i]:
                inc = A[i-1] + 1
                ret += inc - A[i]
                A[i] = inc;

        return ret
