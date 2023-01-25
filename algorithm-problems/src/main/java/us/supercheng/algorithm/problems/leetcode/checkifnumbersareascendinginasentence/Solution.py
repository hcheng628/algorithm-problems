class Solution(object):
    def areNumbersAscending(self, s):
        """
        :type s: str
        :rtype: bool
        """
        prev = -1

        for a in s.split(" "):
            if a.isdigit():
                num = int(a)
                if num <= prev:
                    return False
                prev = num

        return True