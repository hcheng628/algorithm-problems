class Solution(object):
    def similarPairs(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        ret = 0
        seq_map = [self.build_seq(w) for w in words]

        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                if seq_map[i] == seq_map[j]:
                    ret += 1

        return ret

    def build_seq(self, s):
        ret = 0
        for ss in s:
            ret |= 1 << (ord(ss) - ord('a'))

        return ret
