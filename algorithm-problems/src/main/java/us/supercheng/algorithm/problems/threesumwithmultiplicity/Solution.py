class Solution:
    def threeSumMulti(self, A: List[int], target: int) -> int:
        map = {}
        ret = 0

        for a in A:
            map[a] = map[a] + 1 if a in map else 1

        for i in map:
            for j in map:
                k = target - i - j
                if k > -1 and k in map:
                    if i == j and j == k:
                        ret += map[i] * (map[i]-1) * (map[i]-2) // 6
                    elif i == j and j != k:
                        ret += map[i] * (map[i]-1) // 2 * map[k]
                    elif i < j and j < k:
                        ret += map[i] * map[j] * map[k]

        return ret % 1000000007
