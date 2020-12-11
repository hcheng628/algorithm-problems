class Solution:
    def minAreaRect(self, points: List[List[int]]) -> int:
        ret = 0
        L = len(points)
        m = {}

        for p in points:
            if p[0] not in m:
                m[p[0]] = {}
            m[p[0]][p[1]] = True

        for i in range(L):
            for j in range(i+1, L):
                a = points[i]
                b = points[j]
                res = abs(a[0] - b[0]) * abs(a[1] - b[1])

                if res != 0 and (ret == 0 or res < ret) and \
                    a[0] in m and b[1] in m[a[0]] and b[0] in m and a[1] in m[b[0]]:
                    ret = res

        return ret
