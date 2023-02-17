class Solution(object):
    def fillCups(self, amount):
        """
        :type amount: List[int]
        :rtype: int
        """
        if sum(amount) == 0:
            return 0

        amount = sorted(amount)

        if amount[1] > 0:
            amount[1] -= 1
        amount[2] -= 1

        return 1 + self.fillCups(amount)
