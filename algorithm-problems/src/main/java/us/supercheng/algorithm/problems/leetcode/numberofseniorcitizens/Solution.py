class Solution:
    def countSeniors(self, details: List[str]) -> int:
        return sum([1 if d[11:13] > '60' else 0 for d in details])
