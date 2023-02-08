class Solution(object):
    def countOperations(self, num1, num2):
        """
        :type num1: int
        :type num2: int
        :rtype: int
        """
        ret = 0

        while num1 != 0 and num2 != 0:
            if num1 < num2:
                ret += num2 / num1
                num2 = num2 % num1
            else:
                ret += num1 / num2
                num1 = num1 % num2

        return ret
