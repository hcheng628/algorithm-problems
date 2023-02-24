class Solution(object):
    def commonFactors(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        ret = 0

        for n in range(1, min(a, b) + 1):
            if a % n == 0 and b % n == 0:
                ret += 1

        return ret
