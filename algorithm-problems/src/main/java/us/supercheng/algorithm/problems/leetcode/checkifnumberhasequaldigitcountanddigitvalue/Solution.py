class Solution(object):
    def digitCount(self, num):
        """
        :type num: str
        :rtype: bool
        """
        count = collections.Counter(num)
        for i in range(len(num)):
            if count[str(i)] != int(num[i]):
                return False

        return True
