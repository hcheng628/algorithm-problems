class Solution(object):
    def repeatedCharacter(self, s):
        """
        :type s: str
        :rtype: str
        """
        visited = [False] * 26

        for c in s:
            if visited[ord(c) - ord('a')]:
                return c
            visited[ord(c) - ord('a')] = True

        return '-'
