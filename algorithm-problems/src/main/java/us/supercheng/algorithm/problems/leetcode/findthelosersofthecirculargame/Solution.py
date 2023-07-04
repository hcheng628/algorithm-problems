class Solution:
    def circularGameLosers(self, n: int, k: int) -> List[int]:
        ret = []
        visited = [False] * n
        r = 1
        idx = 0

        while not visited[idx]:
            visited[idx] = True
            idx = (idx + r * k) % n
            r += 1

        for i in range(n):
            if not visited[i]:
                ret.append(i + 1)

        return ret
