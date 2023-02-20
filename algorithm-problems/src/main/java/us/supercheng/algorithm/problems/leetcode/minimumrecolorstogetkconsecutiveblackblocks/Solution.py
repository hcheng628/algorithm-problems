class Solution(object):
    def minimumRecolors(self, blocks, k):
        """
        :type blocks: str
        :type k: int
        :rtype: int
        """
        ret = k
        left = 0
        curr = 0

        for right in range(len(blocks)):
            if blocks[right] == 'W':
                curr += 1
            if right - left + 1 == k:
                ret = min(curr, ret)
                if blocks[left] == 'W':
                    curr -= 1
                left += 1

        return ret
