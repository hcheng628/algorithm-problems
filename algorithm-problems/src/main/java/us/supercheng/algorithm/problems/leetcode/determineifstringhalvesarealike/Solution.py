class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vowels = { "a", "e", "i", "o", "u", "A", "E", "I", "O", "U"}

        half = len(s) // 2
        a = 0
        b = 0

        for i in range(half):
            if s[i] in vowels:
                a += 1
            if s[i+half] in vowels:
                b += 1

        return a == b
