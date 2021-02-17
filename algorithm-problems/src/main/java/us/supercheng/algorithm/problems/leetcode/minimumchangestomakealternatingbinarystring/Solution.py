class Solution:
    def minOperations(self, s: str) -> int:
        count = 0
        l = list(s)

        for i in range(1, len(l)):
            if l[i - 1] == l[i]:
                l[i] = '1' if l[i - 1] == '0' else '0'
                count += 1

        return min(count, len(s) - count)
