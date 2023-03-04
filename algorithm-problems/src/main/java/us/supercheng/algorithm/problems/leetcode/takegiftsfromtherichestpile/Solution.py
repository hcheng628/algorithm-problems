from queue import PriorityQueue

class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        q = PriorityQueue()
        ret = 0

        for g in gifts:
            q.put(-g, g)
            ret += g

        for i in range(k):
            val = abs(q.get())
            sqrt_val = int(sqrt(val))
            if sqrt_val == val:
                break

            q.put(-sqrt_val, sqrt_val)
            ret -= val - sqrt_val

        return ret
