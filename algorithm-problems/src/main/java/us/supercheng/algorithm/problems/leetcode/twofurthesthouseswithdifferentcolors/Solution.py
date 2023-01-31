class Solution(object):
    def maxDistance(self, colors):
        """
        :type colors: List[int]
        :rtype: int
        """
        ret = 0
        length = len(colors)
        idx = length - 1

        for i in range(length - 1, -1, -1):
            if colors[0] != colors[i]:
                ret = i
                break
        for i in range(length):
            if colors[i] != colors[length - 1]:
                ret = max(ret, length - 1 - i)
                break

        return ret
