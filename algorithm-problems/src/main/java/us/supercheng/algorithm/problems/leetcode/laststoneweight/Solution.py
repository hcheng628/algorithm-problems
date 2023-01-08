class Solution(object):
    def lastStoneWeight(self, stones):
        """
        :type stones: List[int]
        :rtype: int
        """
        stones = sorted(stones)

        while len(stones) > 1:
            last = stones.pop()
            sec_last = stones.pop()
            if last != sec_last:
                stones.append(last - sec_last)
                stones = sorted(stones)

        return 0 if len(stones) == 0 else stones[0]