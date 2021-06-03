class Solution:
    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        return self.getNum(firstWord) + self.getNum(secondWord) == self.getNum(targetWord)

    def getNum(self, s):
        ret = 0
        base = 1

        for c in reversed(s):
            ret += (ord(c) - ord('a')) * base
            base *= 10

        return ret
