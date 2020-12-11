class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        ret = -1
        m = {}

        for idx in range (len(s)):
            if s[idx] in m:
                m[s[idx]].append(idx)
            else:
                m[s[idx]] = [idx]

        for c in m:
            l = len(m[c])
            if l > 1 and m[c][l-1] - m[c][0] - 1 > ret:
                ret = m[c][l-1] - m[c][0] - 1

        return ret