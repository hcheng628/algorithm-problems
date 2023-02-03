class Solution(object):
    def checkString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s is None:
            return False

        idx_b = s.find('b')
        return idx_b < 0 or s.rfind('a') < idx_b

    def checkString_1line(self, s):
        return True if "ba" not in s else False
