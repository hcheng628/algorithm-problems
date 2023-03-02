class Solution(object):
    def closetTarget(self, words, target, startIndex):
        """
        :type words: List[str]
        :type target: str
        :type startIndex: int
        :rtype: int
        """
        f_idx = startIndex
        b_idx = startIndex
        ret = 0

        while ret < len(words):
            if words[f_idx] == target or words[b_idx] == target:
                return ret
            f_idx += 1
            if f_idx == len(words):
                f_idx = 0

            b_idx -= 1
            if b_idx == -1:
                b_idx = len(words) - 1

            ret += 1

        return -1 if ret == len(words) else ret
