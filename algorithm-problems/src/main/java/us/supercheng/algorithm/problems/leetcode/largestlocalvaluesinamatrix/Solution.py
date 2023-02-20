class Solution(object):
    def largestLocal(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: List[List[int]]
        """
        ret = [[0] * (len(grid) - 2) for i in range(len(grid) - 2)]

        for i in range(len(grid) - 2):
            for j in range(len(grid) - 2):
                ret[i][j] = self.getMax(grid, i, j)

        return ret

    def getMax(self, g, i, j):
        ret = g[i][j]

        for ii in range(3):
            for jj in range(3):
                ret = max(g[ii + i][jj + j], ret)

        return ret
