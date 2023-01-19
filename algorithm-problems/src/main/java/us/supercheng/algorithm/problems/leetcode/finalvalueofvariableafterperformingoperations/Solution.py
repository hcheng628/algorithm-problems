class Solution(object):
    def finalValueAfterOperations(self, operations):
        """
        :type operations: List[str]
        :rtype: int
        """
        ret = 0

        for o in operations:
            ret += 1 if o[1] == '+' else -1

        return ret