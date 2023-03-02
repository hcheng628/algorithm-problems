class Solution:
    def captureForts(self, forts: List[int]) -> int:
        ret = 0
        count = 0
        prev = 13

        for i in range(len(forts)):
            if forts[i] == 0:
                count += 1
            else:
                if prev != 13 and prev != forts[i]:
                    ret = max(count, ret)
                prev = forts[i]
                count = 0

        return ret
