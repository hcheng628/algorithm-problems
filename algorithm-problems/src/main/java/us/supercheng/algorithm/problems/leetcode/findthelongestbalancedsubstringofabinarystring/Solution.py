class Solution:
    def findTheLongestBalancedSubstring(self, s: str) -> int:
        if s is None or len(s) < 2:
            return 0

        tar = '01'
        while len(tar) <= len(s):
            if tar in s:
                tar = '0' + tar + '1'
            else:
                break

        return len(tar) - 2
