class Solution(object):
    def countPoints(self, rings):
        """
        :type rings: str
        :rtype: int
        """
        bucket = [0] * 10
        for i in range(0, len(rings), 2):
            c = rings[i]
            if c == 'R':
                bucket[ord(rings[i + 1]) - ord('0')] |= 1
            elif c == 'G':
                bucket[ord(rings[i + 1]) - ord('0')] |= 2
            else:
                bucket[ord(rings[i + 1]) - ord('0')] |= 4

        return len([b for b in bucket if b == 7])
