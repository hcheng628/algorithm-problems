class Solution:
    def smallestRangeII(self, A: List[int], K: int) -> int:
        A.sort()
        length = len(A)
        lastIdx = length - 1
        ret = A[lastIdx] - A[0]

        for idx in range(1, length):
            ret = min(ret, max(A[idx-1] + K, A[lastIdx] - K) - min(A[0] + K, A[idx] - K))

        return ret