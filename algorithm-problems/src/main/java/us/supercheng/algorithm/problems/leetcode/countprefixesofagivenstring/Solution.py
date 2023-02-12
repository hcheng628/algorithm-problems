class Solution(object):
    def countPrefixes(self, words, s):
        """
        :type words: List[str]
        :type s: str
        :rtype: int
        """
        ret = 0

        for w in words:
            if w == s[:len(w)]:
                ret += 1

        return ret
