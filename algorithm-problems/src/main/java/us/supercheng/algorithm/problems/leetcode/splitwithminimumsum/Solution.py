class Solution:
    def splitNum(self, num: int) -> int:
        a, b = 0, 0
        l = sorted(list(str(num)))

        for i in range(0, len(l), 2):
            a = a * 10 + (ord(l[i]) - ord('0'))
            if i + 1 < len(l):
                b = b * 10 + (ord(l[i + 1]) - ord('0'))

        return a + b
