class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        chars = [char for char in word]
        s = set()

        for i in range(len(chars)):
            if not chars[i].isdigit():
                chars[i] = ' '

        for token in "".join(chars).split(" "):
            if len(token) > 0:
                s.add(int(token))

        return len(s)
