class Solution:
    def trimMean(self, arr: List[int]) -> float:
        L = len(arr)
        idx = int(L * .05)
        arr.sort()

        return sum(arr[idx:-idx]) / (L - idx - idx)
