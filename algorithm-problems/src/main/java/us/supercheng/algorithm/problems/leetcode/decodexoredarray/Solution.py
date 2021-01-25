class Solution:
    def decode(self, encoded: List[int], first: int) -> List[int]:
        ret = [first]

        for num in encoded:
            ret.append(num ^ ret[-1])

        return ret