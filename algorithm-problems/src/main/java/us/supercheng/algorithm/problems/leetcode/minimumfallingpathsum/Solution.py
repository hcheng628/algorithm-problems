class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        rowL = len(A)
        colL = len(A[0])
        dp = []

        for i in range(colL):
            dp.append(A[0][i])

        for r in range(1, rowL):
            temp = []
            for c in range(colL):
                res = dp[c]
                if c - 1 > -1 and res > dp[c-1]:
                    res = dp[c-1]

                if c + 1 < colL and res > dp[c+1]:
                    res = dp[c+1]

                temp.append(res + A[r][c])
            dp = temp

        return min(dp)
