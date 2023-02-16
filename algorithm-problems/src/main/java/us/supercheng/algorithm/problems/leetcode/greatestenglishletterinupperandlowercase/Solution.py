class Solution(object):
    def greatestLetter(self, s):
        """
        :type s: str
        :rtype: str
        """
        for c in list( map( chr, range(ord('Z'), ord('A') - 1,  -1) ) ):
            if s.find(c) > -1 and s.find(c.lower()) > -1:
                return c

        return ""
