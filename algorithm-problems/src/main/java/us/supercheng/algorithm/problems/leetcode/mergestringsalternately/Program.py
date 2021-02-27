class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        l = []
        L1 = len(word1)
        L2 = len(word2)
        endIdx = min(L1, L2)

        for i in range(endIdx):
            l.append(word1[i])
            l.append(word2[i])

        for i in range(endIdx, L1):
            l.append(word1[i])

        for i in range(endIdx, L2):
            l.append(word2[i])

        return "".join(l)
