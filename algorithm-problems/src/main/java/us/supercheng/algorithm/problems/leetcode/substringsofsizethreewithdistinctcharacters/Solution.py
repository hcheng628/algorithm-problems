class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        ret = 0
        left = 0
        right = 0

        while right < len(s):
            size = right - left + 1

            if size < 3:
                right += 1
            elif size == 3:
                a = s[left]
                b = s[left + 1]
                c = s[right]
                if a != b and a != c and b != c:
                    ret += 1
                right += 1
            else:
                left += 1

        return ret