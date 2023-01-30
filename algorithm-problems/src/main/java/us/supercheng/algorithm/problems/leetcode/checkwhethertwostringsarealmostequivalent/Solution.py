class Solution(object):
    def checkAlmostEquivalent(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: bool
        """
        res1 = collections.Counter(word1)
        res2 = collections.Counter(word2)

        for idx in range(ord('a'), ord('z') + 1):
            if abs(res1[chr(idx)] - res2[chr(idx)]) > 3:
                return False

        return True