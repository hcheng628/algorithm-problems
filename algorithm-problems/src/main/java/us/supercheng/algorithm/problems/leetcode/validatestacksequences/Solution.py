class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = []
        s = set()
        idx = 0
        L = len(pushed)

        for p in pushed:
            stack.append(p)
            s.add(p)

            while stack and idx < L and stack[-1] == popped[idx]:
                stack.pop()
                idx += 1

            if idx < L and popped[idx] in s:
                return False

        return True
