class Solution(object):
    def reversePrefix(self, word, ch):
        """
        :type word: str
        :type ch: str
        :rtype: str
        """
        if word is None or len(word) < 2:
            return word

        right = word.find(ch)
        if right == -1:
            return word

        left = 0
        arr = list(word)
        while left < right:
            arr[left] = word[right]
            arr[right] = word[left]
            left += 1
            right -= 1

        return "".join(arr)
