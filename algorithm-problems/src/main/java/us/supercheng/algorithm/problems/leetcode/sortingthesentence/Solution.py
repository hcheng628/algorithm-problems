class Solution:
    def sortSentence(self, s: str) -> str:
        arr = s.split()
        words = [None] * len(arr)

        for a in arr:
            words[int(a[len(a) - 1]) - 1] = a[0: len(a) - 1]

        return " ".join(words)
