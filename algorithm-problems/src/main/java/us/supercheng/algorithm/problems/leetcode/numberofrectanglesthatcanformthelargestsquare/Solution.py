class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        max_len = max(min(r) for r in rectangles)
        return sum (1 for r in rectangles if min(r) == max_len)