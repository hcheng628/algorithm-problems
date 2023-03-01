class Solution(object):
    def closetTarget(self, words, target, startIndex):
        """
        :type words: List[str]
        :type target: str
        :type startIndex: int
        :rtype: int
        """
        f_idx, b_idx = startIndex, startIndex
        f_steps, b_steps = 0, 0

        while (f_idx != -1 and f_steps < len(words)) or (b_idx != -1 and b_steps < len(words)):
            if f_idx != -1:
                if words[f_idx] == target:
                    f_idx = -1
                else:
                    f_idx = self.next_idx(len(words), f_idx, True)
                    f_steps += 1

            if b_idx != -1:
                if words[b_idx] == target:
                    b_idx = -1
                else:
                    b_idx = self.next_idx(len(words), b_idx, False)
                    b_steps += 1

        return -1 if min(f_steps, b_steps) == len(words) else min(f_steps, b_steps)

    def next_idx(self, length, i, forward):
        return (i + 1 if i + 1 < length else 0) if forward else (i - 1 if i - 1 > -1 else length - 1)
