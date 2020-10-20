from typing import List

class Solution:
    def mostVisited(self, n: int, rounds: List[int]) -> List[int]:
        visited = [0] * (n + 1)
        length = len(rounds)

        for i in range(length - 1):
            self.travel(visited, rounds[i], rounds[i + 1], n)
        visited[rounds[length - 1]] += 1

        ret = []
        maxV = max(visited)

        for i in range(1, n + 1):
            if visited[i] == maxV:
                ret.append(i)

        return ret

    def travel(self, visited: List[int], fr: int, to: int, N: int):
        if fr <= to:
            while fr < to:
                visited[fr] += 1
                fr += 1
        else:
            while fr <= N:
                visited[fr] += 1
                fr += 1

            fr = 1
            while fr < to:
                visited[fr] += 1
                fr += 1

        return fr
