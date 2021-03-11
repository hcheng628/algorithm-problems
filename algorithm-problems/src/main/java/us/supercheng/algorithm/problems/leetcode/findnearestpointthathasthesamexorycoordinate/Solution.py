class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        dis = None
        ret = -1

        for i in range(len(points)):
            if points[i][0] == x or points[i][1] == y:
                curr_dis = self.calDis(points[i][0], points[i][1], x, y)
                if dis is None or curr_dis < dis:
                    dis = curr_dis
                    ret = i

        return ret

    def calDis(self, x1, y1, x2, y2):
        return abs(x1 - x2) + abs(y1- y2)
