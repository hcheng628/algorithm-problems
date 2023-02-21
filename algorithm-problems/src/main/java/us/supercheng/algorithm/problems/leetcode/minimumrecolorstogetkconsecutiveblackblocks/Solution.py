class Solution(object):
    def minimumRecolors(self, blocks, k):
        """
        :type blocks: str
        :type k: int
        :rtype: int
        """
        ret = k
        curr = 0

        for right in range(len(blocks)):
            if blocks[right] == 'W':
                curr += 1
            if right + 1 > k and blocks[right - k] == 'W':
                curr -= 1
            if right + 1 >= k:
                ret = min(curr, ret)

        return ret
