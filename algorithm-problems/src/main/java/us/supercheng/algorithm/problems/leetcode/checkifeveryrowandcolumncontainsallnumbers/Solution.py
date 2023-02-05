class Solution(object):
    def checkValid(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        return self.valid(matrix, True) and self.valid(matrix, False)

    def valid(self, mat, is_row):
        for i in range(len(mat)):
            unique = [False] * (len(mat) + 1)
            for j in range(len(mat)):
                num = mat[i][j] if is_row else mat[j][i]
                if unique[num]:
                    return False
                unique[num] = True

        return True
