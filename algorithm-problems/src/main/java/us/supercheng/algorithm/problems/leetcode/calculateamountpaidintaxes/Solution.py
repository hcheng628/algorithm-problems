class Solution(object):
    def calculateTax(self, brackets, income):
        """
        :type brackets: List[List[int]]
        :type income: int
        :rtype: float
        """
        if brackets is None or len(brackets) < 1:
            return 0.0

        ret = min(income, brackets[0][0]) * (brackets[0][1] / 100.0)
        income -= min(income, brackets[0][0])

        for i in range(1, len(brackets)):
            taxable = min(income, brackets[i][0] - brackets[i - 1][0])
            ret += taxable * (brackets[i][1] / 100.0)
            income -= taxable

        return ret
