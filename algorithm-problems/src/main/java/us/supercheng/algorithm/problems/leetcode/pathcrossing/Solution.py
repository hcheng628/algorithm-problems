class Solution:
    def isPathCrossing(self, path: str) -> bool:
        visited = {}
        curr = (0,0)
        visited[curr] = True

        for p in path:
            if p == 'N':    curr = (curr[0], curr[1]+1)
            elif p == 'S':  curr = (curr[0], curr[1]-1)
            elif p == 'W':  curr = (curr[0]-1, curr[1])
            elif p == 'E':  curr = (curr[0]+1, curr[1])
            else:           raise Exception('Solution', 'wrong path code')

            if curr in visited: return True
            visited[curr] = True;

        return False