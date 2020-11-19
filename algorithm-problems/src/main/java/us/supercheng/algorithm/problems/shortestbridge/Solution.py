import queue

class Solution:
    def shortestBridge(self, A: List[List[int]]) -> int:
        q = queue.SimpleQueue()
        R = len(A)
        C = len(A[0])
        ret = 0
        finding = True

        for i in range(R):
            for j in range(C):
                if A[i][j] == 1:
                    self.findIsland(A, R, C, q, i, j)
                    finding = False
                    break
            if not finding:
                break

        while not q.empty():
            size = q.qsize()
            for s in range(size):
                curr = q.get()
                curr_x = curr // 100
                curr_y = curr % 100

                if curr_x + 1 < R:
                    if A[curr_x + 1][curr_y] == 1:
                        return ret
                    elif A[curr_x + 1][curr_y] == 0:
                        A[curr_x + 1][curr_y] = 2
                        q.put(self.normPos(curr_x + 1, curr_y))

                if curr_x - 1 > -1:
                    if A[curr_x - 1][curr_y] == 1:
                        return ret
                    elif A[curr_x - 1][curr_y] == 0:
                        A[curr_x - 1][curr_y] = 2
                        q.put(self.normPos(curr_x - 1, curr_y))

                if curr_y + 1 < C:
                    if A[curr_x][curr_y + 1] == 1:
                        return ret
                    elif A[curr_x][curr_y + 1] == 0:
                        A[curr_x][curr_y + 1] = 2
                        q.put(self.normPos(curr_x, curr_y + 1))

                if curr_y - 1 > -1:
                    if A[curr_x][curr_y - 1] == 1:
                        return ret
                    elif A[curr_x][curr_y - 1] == 0:
                        A[curr_x][curr_y - 1] == 2
                        q.put(self.normPos(curr_x, curr_y - 1))
            ret += 1

        return ret


    def findIsland(self, A: List[List[int]], R: int, C: int, q, x: int, y: int) -> None:
        if x < 0 or y < 0 or x >= R or y >= C or A[x][y] == 2 or A[x][y] == 0:
            return

        q.put(self.normPos(x, y))
        A[x][y] = 2
        self.findIsland(A, R, C, q, x + 1, y)
        self.findIsland(A, R, C, q, x - 1, y)
        self.findIsland(A, R, C, q, x, y + 1)
        self.findIsland(A, R, C, q, x, y - 1)


    def normPos(self, x: int, y: int) -> int:
        return x * 100 + y
