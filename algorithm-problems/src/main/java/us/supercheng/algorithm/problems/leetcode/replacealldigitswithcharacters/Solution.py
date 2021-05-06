class Solution:
    def replaceDigits(self, s: str) -> str:
        idx = 1
        l = list(s)

        while idx < len(s):
            l[idx] = chr(ord(l[idx - 1]) + ord(l[idx]) - ord('0'))
            idx += 2

        return "".join(l)