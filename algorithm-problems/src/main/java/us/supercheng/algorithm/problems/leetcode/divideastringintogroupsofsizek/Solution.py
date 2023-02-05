class Solution(object):
    def divideString(self, s, k, fill):
        """
        :type s: str
        :type k: int
        :type fill: str
        :rtype: List[str]
        """
        ret = []
        i = 0

        for i in range(0, len(s) / k):
            ret.append(s[i*k:i*k+k])

        end_idx = len(s) - ((i + 1) * k)
        if end_idx == 0:
            return ret

        tmp = [s[-end_idx:] if end_idx > 0 else s]
        tmp.append((k - len(tmp[0])) * fill)
        ret.append("".join(tmp))
        return ret
