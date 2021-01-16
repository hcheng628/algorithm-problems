class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        ret = 0
        boxTypes.sort(key = lambda unit:-unit[1])

        for box in boxTypes:
            amt = box[0]
            unit = box[1]

            if amt <= truckSize:
                ret += amt * unit
                truckSize -= amt
            else:
                ret += truckSize * unit
                truckSize = 0;

            if truckSize == 0:
                break

        return ret
