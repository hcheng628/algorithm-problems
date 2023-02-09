class Solution(object):
    def cellsInRange(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        ret = []

        for c in range(ord(s[0]) - ord('A'), ord(s[3]) - ord('A') + 1):
            for r in range(ord(s[1]) - ord('0'), ord(s[4]) - ord('0') + 1):
                ret.append("".join([chr(c + ord('A')), str(r)]))

        return ret
