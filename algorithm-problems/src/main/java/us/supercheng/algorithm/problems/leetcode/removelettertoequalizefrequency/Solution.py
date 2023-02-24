class Solution(object):
    def equalFrequency(self, word):
        """
        :type word: str
        :rtype: bool
        """
        length = len(word)

        for idx in range(length):
            count = [0] * 26
            for i in range(length):
                if i != idx:
                    count[ord(word[i]) - ord('a')] += 1
            success = True
            freq = 0
            for i in range(26):
                if count[i] != 0:
                    if freq == 0:
                        freq = count[i]
                    elif freq != count[i]:
                        success = False
                        break
            if success:
                return True

        return False
