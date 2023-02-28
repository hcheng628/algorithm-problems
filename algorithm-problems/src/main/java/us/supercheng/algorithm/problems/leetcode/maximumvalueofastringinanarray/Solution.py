class Solution(object):
    def maximumValue(self, strs):
        """
        :type strs: List[str]
        :rtype: int
        """
        return max([self.toInt(s) for s in strs])

    def toInt(self, s):
        base = 0

        for i in range(len(s)):
            if s[i].isalpha():
                return len(s)
            base = base * 10 + (ord(s[i]) - ord('0'))

        return base
