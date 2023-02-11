class Solution(object):
    def minBitFlips(self, start, goal):
        """
        :type start: int
        :type goal: int
        :rtype: int
        """
        ret = 0
        diff = start ^ goal

        while diff != 0:
            ret += diff & 1
            diff >>= 1

        return ret
