class Solution(object):
    def countWords(self, words1, words2):
        """
        :type words1: List[str]
        :type words2: List[str]
        :rtype: int
        """
        ret = 0
        m1 = collections.Counter(words1)
        m2 = collections.Counter(words2)

        for w in words1:
            if m1[w] == 1 and m2[w] == 1:
                ret += 1

        return ret
