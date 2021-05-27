class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        bucket = {}
        max_val = 0
        ret = 0

        for log in logs:
            for i in range(log[0], log[1]):
                bucket[i] = bucket[i] + 1 if i in bucket else 1

        for i in range(1950, 2051):
            if i in bucket and bucket[i] > max_val:
                max_val = bucket[i]
                ret = i

        return ret