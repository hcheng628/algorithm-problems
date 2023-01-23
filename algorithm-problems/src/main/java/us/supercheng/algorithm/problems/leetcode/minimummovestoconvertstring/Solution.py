class Solution(object):
    def minimumMoves(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s is None or len(s) < 1:
            return 0

        ret = 0
        i = 0
        length = len(s)

        while  i < length:
            if s[i] == 'X':
                i += 3
                ret += 1
            else:
                i += 1

        return ret
