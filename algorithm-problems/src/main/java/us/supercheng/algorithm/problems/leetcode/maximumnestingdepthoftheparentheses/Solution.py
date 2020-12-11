class Solution:
    def maxDepth(self, s: str) -> int:
        ret = 0
        stack = 0
        
        for ss in s:
            if ss == '(':
                stack +=1
                ret = max(stack, ret)
            elif ss == ')':
                stack -=1
        
        return ret
