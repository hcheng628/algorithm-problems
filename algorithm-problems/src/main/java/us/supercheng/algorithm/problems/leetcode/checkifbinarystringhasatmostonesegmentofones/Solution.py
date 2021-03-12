class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        l = []
        for i in range(len(s)):
            if s[i] == '1':
                if len(l) > 0 and l[-1] + 1 != i:
                    return False
                l.append(i)

        return True
