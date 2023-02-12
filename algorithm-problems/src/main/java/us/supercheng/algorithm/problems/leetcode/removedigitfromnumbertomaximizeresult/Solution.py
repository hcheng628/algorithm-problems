class Solution(object):
    def removeDigit(self, number, digit):
        """
        :type number: str
        :type digit: str
        :rtype: str
        """
        idx = -1
        for i in range(0, len(number)):
            if number[i] == digit:
                if i + 1 < len(number) and digit < number[i + 1]:
                    return number[:i] + number[i + 1:]
                idx = i

        return number[0:idx] + number[idx + 1:]
