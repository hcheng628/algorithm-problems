class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        ret = 0
        L = len(sequence)
        W = len(word)

        for i in range(L):
            idx = 0
            while idx + i < L and sequence[idx+i] == word[idx % W]:
                idx +=1

            ret = max(idx // W, ret)

        return ret

    def maxRepeatingStrApproach(self, sequence: str, word: str) -> int:
        ret = 0
        s = word

        while s in sequence:
            s += word
            ret += 1

        return ret
