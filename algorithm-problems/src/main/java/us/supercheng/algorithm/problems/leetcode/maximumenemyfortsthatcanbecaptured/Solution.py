class Solution(object):
    def captureForts(self, forts):
        """
        :type forts: List[int]
        :rtype: int
        """
        ret = 0
        pos = [idx for idx, val in enumerate(forts) if val != 0]

        for i in range(len(pos) - 1):
            if forts[pos[i]] != forts[pos[i + 1]] and ret < pos[i + 1] - pos[i] - 1:
                ret = pos[i + 1] - pos[i] - 1

        return ret
