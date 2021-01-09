class Solution:
    def reformatNumber(self, number: str) -> str:
        list = []
        
        for c in number:
            if c.isdigit():
                list.append(c)

        idx = 0
        L = len(list)
        ans = []
        
        while idx < L:
            if idx + 4 == L:
                ans.append(list[idx] + list[idx+1])
                ans.append(list[idx+2] + list[idx+3])
                idx += 4
            elif idx + 2 == L:
                ans.append(list[idx] + list[idx+1])
                idx+=2
            else:
                ans.append(list[idx] + list[idx+1] + list[idx+2])
                idx +=3
        
        return "-".join(ans)
