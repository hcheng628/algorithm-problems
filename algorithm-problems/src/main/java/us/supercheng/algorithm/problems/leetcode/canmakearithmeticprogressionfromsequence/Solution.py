class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        length = len(arr)
        if length < 3:
            return True

        arr.sort()
        diff = arr[1] - arr[0]
        for i in range(2, length):
            if arr[i] - arr[i-1] != diff:
                return False

        return True
