class Solution(object):
    def prefixCount(self, words, pref):
        """
        :type words: List[str]
        :type pref: str
        :rtype: int
        """
        ret = 0

        for w in words:
            if w.find(pref) == 0:
                ret += 1

        return ret
