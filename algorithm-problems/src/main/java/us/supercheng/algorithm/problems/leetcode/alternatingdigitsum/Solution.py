class Solution:
    def alternateDigitSum(self, n: int) -> int:
        s = str(n)
        return sum([ord(s[i]) - ord('0') if i % 2 == 0 else -(ord(s[i]) - ord('0')) for i in range(len(s))])
