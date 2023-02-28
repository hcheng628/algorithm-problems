class Solution(object):
    def isCircularSentence(self, sentence):
        """
        :type sentence: str
        :rtype: bool
        """
        arr = sentence.split(" ")

        if arr[0][0] != arr[-1][-1]:
            return False

        for i in range(1, len(arr)):
            if arr[i - 1][-1] != arr[i][0]:
                return False

        return True
