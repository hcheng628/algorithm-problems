class Solution:
    def findColumnWidth(self, grid: List[List[int]]) -> List[int]:
        ret = []

        for c in range(len(grid[0])):
            currLen = 0
            for r in range(len(grid)):
                currLen = max(self.calLen(grid[r][c]), currLen)
            ret.append(currLen)

        return ret

    def calLen(self, n):
        if n == 0:
            return 1

        ret = 1 if n < 0 else 0
        nn = abs(n)

        while nn > 0:
            nn //= 10
            ret += 1

        return ret
