class Solution(object):
    def timeRequiredToBuy(self, tickets, k):
        """
        :type tickets: List[int]
        :type k: int
        :rtype: int
        """
        ret = 0

        for i in range(len(tickets)):
            if i <= k:
                ret += min(tickets[i], tickets[k])
            else:
                ret += min(tickets[i], tickets[k] - 1)

        return ret
