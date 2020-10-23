class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        ret = 0
        size = 1
        L = len(arr)

        while size <=L:
            ret += self.sumHelper(arr, L, size)
            size+=2

        return ret

    def sumHelper(self, arr:List[int], L:int, size:int) -> int:
        ret = 0
        prev = 0

        for i in range(L-size+1):
            curr = 0
            if i == 0:
                for idx in range(size):
                    curr += arr[idx]
            else:
                curr += prev + arr[i+size-1] - arr[i-1]

            ret += curr
            prev = curr

        return ret
