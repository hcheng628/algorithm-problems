class Solution(object):
    def haveConflict(self, event1, event2):
        """
        :type event1: List[str]
        :type event2: List[str]
        :rtype: bool
        """
        return event1[0] <= event2[1] <= event1[1] or event2[0] <= event1[1] <= event2[1]
