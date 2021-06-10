class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        size = len(mat)

        for i in range(4):
            mat = self.rotate(mat, size)
            if self.is_same(mat, target, size):
                return True

        return False

    def rotate(self, mat, size):
        ret = []

        for i in range(size):
            ret.append([])
            idx = len(ret) - 1
            for j in range(size):
                ret[idx].append([])

        col = size - 1
        for i in range(size):
            for j in range(size):
                ret[j][col] = mat[i][j]
            col -= 1

        return ret

    def is_same(self, a, b, size):
        for i in range(size):
            for j in range(size):
                if a[i][j] != b[i][j]:
                    return False

        return True
