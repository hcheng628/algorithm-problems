class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        m = set()
        ret = 0

        for a in allowed:
            m.add(a)

        for w in words:
            is_good = True
            for c in w:
                if c not in m:
                    is_good = False
                    break
            if is_good:
                ret += 1

        return ret
