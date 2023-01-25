class Solution(object):
    def minMovesToSeat(self, seats, students):
        """
        :type seats: List[int]
        :type students: List[int]
        :rtype: int
        """
        ret = 0
        counts = [0] * 101

        for s in seats:
            counts[s] += 1
        for s in students:
            counts[s] -= 1

        for i in range(1, 100):
            ret += abs(counts[i])
            counts[i + 1] += counts[i]

        return ret