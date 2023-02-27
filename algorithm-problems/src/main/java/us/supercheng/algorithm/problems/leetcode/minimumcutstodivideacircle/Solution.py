class Solution(object):
    def numberOfCuts(self, n):
        """
        :type n: int
        :rtype: int
        """
        return 0 if n < 2 else n // 2 if n % 2 == 0 else n
