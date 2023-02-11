class Solution(object):
    def convertTime(self, current, correct):
        """
        :type current: str
        :type correct: str
        :rtype: int
        """
        diff = (int(correct[0:2]) * 60 + int(correct[3:5])) - (int(current[0:2]) * 60 + int(current[3:5]))
        return diff / 60 + diff % 60 / 15 + diff % 15 / 5 + diff % 5
