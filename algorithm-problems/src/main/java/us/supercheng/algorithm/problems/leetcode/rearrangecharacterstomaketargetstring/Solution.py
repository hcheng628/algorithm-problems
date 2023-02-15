class Solution(object):
    def rearrangeCharacters(self, s, target):
        """
        :type s: str
        :type target: str
        :rtype: int
        """
        ret = max(len(s), len(target))
        sCount = collections.Counter(s)
        tarCount = collections.Counter(target)

        for k in tarCount:
            ret = min(ret, sCount[k] // tarCount[k])

        return ret
