class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        arr = []
        for i in range(n):
           arr.append(start + 2 * i)

        ret = arr[0]

        for i in range (1, n):
            ret = ret ^ arr[i]

        return ret;
