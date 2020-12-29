class Solution:
    def numberOfMatches(self, n: int) -> int:
        if n < 2:
            return 0

        matches = n // 2
        next_round = matches if n % 2 == 0 else matches + 1

        return matches + self.numberOfMatches(next_round)