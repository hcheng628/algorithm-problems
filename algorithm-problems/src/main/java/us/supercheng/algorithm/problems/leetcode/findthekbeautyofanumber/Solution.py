class Solution(object):
    def divisorSubstrings(self, num, k):
        """
        :type num: int
        :type k: int
        :rtype: int
        """
        ret = 0
        s = str(num)

        for i in range(len(s)):
            j = i
            curr = 0
            for count in range(k):
                curr = curr * 10 + (ord(s[j]) - ord('0'))
                j += 1
                if j >= len(s):
                    break

            if curr != 0 and i + k == j and num % curr == 0:
                ret += 1

        return ret
