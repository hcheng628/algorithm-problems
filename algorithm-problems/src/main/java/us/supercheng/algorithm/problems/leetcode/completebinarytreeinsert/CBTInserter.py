# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class CBTInserter:

    def __init__(self, root: TreeNode):
        self.list = []

        if root is not None:
            self.list.append(root)

        for curr in self.list:
            if curr.left is not None:
                self.list.append(curr.left)

            if curr.right is not None:
                self.list.append(curr.right)

    def insert(self, v: int) -> int:
        size = len(self.list)
        parent = self.list[size // 2 - 1 if size % 2 == 0 else size // 2]
        node = TreeNode(v)
        self.list.append(node)

        if parent.left is None:
            parent.left = node
        else:
            parent.right = node

        return parent.val

    def get_root(self) -> TreeNode:
        return self.list[0] if len(self.list) > 0 else None


# Your CBTInserter object will be instantiated and called as such:
# obj = CBTInserter(root)
# param_1 = obj.insert(v)
# param_2 = obj.get_root()