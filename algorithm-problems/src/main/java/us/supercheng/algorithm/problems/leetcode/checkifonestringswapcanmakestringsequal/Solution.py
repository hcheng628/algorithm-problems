class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2):
            return False

        l1 = []
        l2 = []

        for i in range(len(s1)):
            if s1[i] != s2[i]:
                l1.append(s1[i])
                l2.append(s2[i])
                if (len(l1) > 2):
                    return False

        return len(l1) == 0 or (len(l1) == 2 and l1[0] == l2[1] and l1[1] == l2[0])
