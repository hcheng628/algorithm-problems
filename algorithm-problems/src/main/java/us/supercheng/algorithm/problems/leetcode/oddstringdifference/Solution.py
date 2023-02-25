class Solution(object):
    def oddString(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        first = self.diff_arr(words[0])
        last = self.diff_arr(words[-1])
        if first == last:
            for i in range(1, len(words) - 1):
                if self.diff_arr(words[i]) != last:
                    return words[i]
        else:
            return words[-1] if self.diff_arr(words[1]) == first else words[0]

        return "something is wrong"

    def diff_arr(self, w):
        return [ord(w[i + 1]) - ord(w[i]) for i in range(len(w) - 1)]
