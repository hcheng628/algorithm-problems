class Solution(object):
    def removeAnagrams(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        ret = []

        for i in range(len(words)):
            if len(ret) == 0 or sorted(ret[-1]) != sorted(words[i]):
                ret.append(words[i])

        return ret
