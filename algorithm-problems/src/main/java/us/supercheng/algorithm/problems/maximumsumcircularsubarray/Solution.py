class Solution:
    def maxSubarraySumCircular(self, A: List[int]) -> int:
        if A is None or len(A) == 0:
            return 0;

        currMin = minVal = currMax = maxVal = total = A[0];

        for i in range (1, len(A)):
            curr = A[i]
            currMin = min(curr + currMin, curr)
            minVal = min(currMin, minVal)

            currMax = max(curr + currMax, curr)
            maxVal = max(currMax, maxVal)

            total += curr

        return maxVal if total == minVal else max(maxVal, total - minVal)