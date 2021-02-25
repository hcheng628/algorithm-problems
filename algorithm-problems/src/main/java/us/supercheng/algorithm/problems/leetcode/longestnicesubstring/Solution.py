class Solution:

    def longestNiceSubstring(self, s: str) -> str:
        ret = ""
        L = len(s)

        for i in range(L):
            if L - i < len(ret):
                break
            for j in range(i, L):
                curr = s[i: j + 1]
                if len(curr) > len(ret) and self.isNice(curr):
                    ret = curr

        return ret

    def isNice(self, s):
        if s is None or len(s) < 2:
            return False

        m = {}
        for c in s:
            m[c] = 1

        for i in range(27):
            low = chr(ord('a') + i)
            cap = chr(ord('A') + i)
            if (low in m and cap not in m) or (low not in m and cap in m):
                return False

        return True
