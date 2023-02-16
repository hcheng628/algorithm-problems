class Solution(object):
    def countAsterisks(self, s):
        """
        :type s: str
        :rtype: int
        """
        ret = 0

        for i, ss in enumerate(s.split("|")):
            if i % 2 == 0:
                ret += ss.count("*")

        return ret
