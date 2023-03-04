class Solution:
    def distinctIntegers(self, n: int) -> int:
        return len(self.helper(set(), n))

    def helper(self, unique, n):
        if n in unique:
            return unique

        unique.add(n)
        for nn in range(n - 1, 1, -1):
            if n % nn == 1:
                self.helper(unique, nn)
        return unique
