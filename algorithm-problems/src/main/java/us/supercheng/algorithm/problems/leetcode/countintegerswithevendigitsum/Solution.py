class Solution(object):
    def countEven(self, num):
        """
        :type num: int
        :rtype: int
        """
        return num / 2 if sum([int(n) for n in str(num)]) % 2 == 0 else (num - 1) / 2
