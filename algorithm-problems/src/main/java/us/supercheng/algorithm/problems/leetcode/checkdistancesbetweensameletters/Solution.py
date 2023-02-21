class Solution(object):
    def checkDistances(self, s, distance):
        """
        :type s: str
        :type distance: List[int]
        :rtype: bool
        """
        for i in range(len(s)):
            idx = ord(s[i]) - ord('a')
            if distance[idx] != -1 and (i + distance[idx] + 1 >= len(s) or s[i] != s[i + distance[idx] + 1]):
                return False
            distance[idx] = -1

        return True
