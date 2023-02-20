class Solution(object):
    def bestHand(self, ranks, suits):
        """
        :type ranks: List[int]
        :type suits: List[str]
        :rtype: str
        """
        if suits[0] == suits[1] and suits[1] == suits[2] and suits[2] == suits[3] and suits[3] == suits[4]:
            return "Flush"

        hasTwoCount = False
        m = collections.Counter(ranks)

        for idx in m:
            if m[idx] > 2:
                return "Three of a Kind"
            elif m[idx] == 2:
                hasTwoCount = True

        return "Pair" if hasTwoCount else "High Card"
