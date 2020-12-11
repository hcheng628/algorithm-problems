class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        ret = []
        m = {}
        curr = 1
        _max = 0

        for n in nums:
            m[n] = m[n] + 1 if n in m else 1
            _max = max(m[n], _max)

        while curr <= _max:
            for n in range(100, -101, -1):
                if n in m and m[n] == curr:
                    ret.extend([n]*curr);
            curr += 1

        return ret
