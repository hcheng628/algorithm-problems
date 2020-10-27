class Solution:
    def minOperations(self, logs: List[str]) -> int:
        level = 0

        for l in logs:
            if l == './':
                continue
            elif l == '../':
                level = (level - 1) if level > 0 else 0
            else:
                level += 1

        return level