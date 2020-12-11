class Solution:

    def minFlipsMonoIncr(self, S: str) -> int:
        L = len(S)
        ret = L
        zeros = 0
        ones = 0
        dp0 = {}
        dp1 = {}

        dp0[0] = 1 if S[0] == '0' else 0
        for i in range(1, L):
            dp0[i] = dp0[i-1] + (1 if S[i] == '0' else 0)

        dp1[L-1] = 1 if S[L-1] == '1' else 0
        for i in range (L-2, -1, -1):
            dp1[i] = dp1[i+1] + (1 if S[i] == '1' else 0)

        for i in range(L):
            if S[i] == '0':
                zeros += 1
            else:
                ones += 1

            left = i + 1
            right = L - left

            ret = min(left - dp0[i] + right - dp1[i], ret)

        return min(L - zeros, L - ones, ret)
