class Solution:
    def kItemsWithMaximumSum(self, numOnes: int, numZeros: int, numNegOnes: int, k: int) -> int:
        if numOnes >= k:
            return k
        return numOnes if numOnes + numZeros >= k else numOnes - k + numOnes + numZeros
