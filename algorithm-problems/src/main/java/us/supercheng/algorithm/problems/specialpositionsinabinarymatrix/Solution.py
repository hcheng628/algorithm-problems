class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        count = 0
        R = len(mat)
        C = len(mat[0])
        visitedRow = {}
        visitedCol = {}

        for i in range(R):
            if i in visitedRow:
                continue
            for j in range(C):
                if j in visitedCol:
                    continue
                if (mat[i][j] == 1 and self.checkRow(mat, R, i, j) and self.checkCol(mat, C, i, j)):
                    visitedRow[i] = True
                    visitedCol[j] = True
                    count += 1
                    break

        return count


    def checkRow(self, mat: List[List[int]], R: int, row: int, col: int) -> bool:
        idx = row - 1
        while idx > -1:
            if mat[idx][col] == 1:
                return False
            idx -= 1

        idx = row + 1
        while idx < R:
            if mat[idx][col] == 1:
                return False
            idx += 1
        return True


    def checkCol(self, mat: List[List[int]], C: int, row: int, col: int) -> bool:
        idx = col - 1
        while idx > -1:
            if mat[row][idx] == 1:
                return False
            idx -= 1


        idx = col + 1
        while idx < C:
            if mat[row][idx] == 1:
                return False
            idx += 1

        return True