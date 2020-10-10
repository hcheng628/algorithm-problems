class Solution:
    def minAddToMakeValid(self, S: str) -> int:
        left = 0
        right = 0

        for c in S:
            if c == '(':
                left += 1
            else:
                if left == 0:
                    right += 1
                else:
                    left -= 1

        return left + right
