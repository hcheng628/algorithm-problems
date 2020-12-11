class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        ret = numBottles

        while numBottles >= numExchange:
            left = numBottles // numExchange
            numBottles = left + numBottles % numExchange
            ret += left

        return ret;
