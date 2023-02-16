class Solution(object):
    def checkXMatrix(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: bool
        """
        length = len(grid)
        for i in range(length):
            for j in range(length):
                if i == j or i + j == length - 1:
                    if grid[i][j] == 0:
                        return False
                elif grid[i][j] != 0:
                    return False

        return True
