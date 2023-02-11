class Solution(object):
    def digitSum(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        while len(s) > k:
            s = "".join(self.replace(self.divide(s, k)))

        return s


    def divide(self, s, k):
        ret = []

        for i in range(0, len(s), k):
            ret.append(s[i:min(i + k, len(s))])

        return ret

    def replace(self, arr):
        ret = []

        for a in arr:
            s = 0
            for aa in a:
                s += ord(aa) - ord('0')
            ret.append(str(s))

        return ret
