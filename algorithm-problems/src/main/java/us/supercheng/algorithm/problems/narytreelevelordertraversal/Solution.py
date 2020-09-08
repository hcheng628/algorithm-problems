class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        ret = []
        q = []

        if root:
            q.append(root)

        while len(q) > 0:
            row = []
            row_count = len(q)
            for i in range(row_count):
                n = q.pop(0)
                row.append(n.val)
                if n.children:
                    for c in n.children:
                        q.append(c)
            ret.append(row)

        return ret;
