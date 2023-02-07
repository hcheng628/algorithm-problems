class Solution(object):
    def minimumSum(self, num):
        """
        :type num: int
        :rtype: int
        """
        digits = sorted([int(digit) for digit in str(num)])
        return (digits[0] + digits[1]) * 10 + digits[2] + digits[3]
