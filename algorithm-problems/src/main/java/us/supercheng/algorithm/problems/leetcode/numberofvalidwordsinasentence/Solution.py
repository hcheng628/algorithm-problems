class Solution(object):
    def countValidWords(self, sentence):
        """
        :type sentence: str
        :rtype: int
        """
        ret = 0

        for s in sentence.split(" "):
            countH = 0
            valid = True
            hasAllowed = False

            for i in range(len(s)):
                if s[i].isdigit():
                    valid = False
                elif s[i] == '-':
                    countH += 1
                    if not (i - 1 > -1 and i + 1 < len(s) and s[i - 1].isalpha() and s[i + 1].isalpha()) or countH > 1:
                        valid = False
                elif s[i] == ',' or s[i] == '.' or s[i] == '!':
                    if i != len(s) - 1:
                        valid = False
                    hasAllowed = True
                elif s[i].isalpha():
                    if s[i].isupper() == s[i]:
                        valid = False
                    else:
                        hasAllowed = True

                if not valid:
                    break

            if valid and hasAllowed:
                ret += 1

        return ret