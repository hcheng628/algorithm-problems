class Solution:
    def deleteGreatestValue(self, grid: List[List[int]]) -> int:
        return sum([max(r) for r in list(zip(*[sorted(g) for g in grid]))])
