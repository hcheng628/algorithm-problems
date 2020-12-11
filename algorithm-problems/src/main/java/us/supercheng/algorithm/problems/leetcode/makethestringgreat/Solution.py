class Solution:
    def makeGood(self, s: str) -> str:
        while True:
            idx = self.checkS(s)
            if idx == -1:
                break
            s = s[0:idx-1] + s[idx+1:]

        return s


    def checkS(self, s: str) -> int:
        if s is None or len(s) < 2:
            return -1

        for i in range(1, len(s)):
            if s[i-1] != s[i] and s[i-1].upper() == s[i].upper():
                return i

        return -1