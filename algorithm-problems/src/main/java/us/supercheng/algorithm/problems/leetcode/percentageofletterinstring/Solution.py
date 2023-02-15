class Solution(object):
    def percentageLetter(self, s, letter):
        """
        :type s: str
        :type letter: str
        :rtype: int
        """
        return int(collections.Counter(s)[letter] / float(len(s)) * 100)
