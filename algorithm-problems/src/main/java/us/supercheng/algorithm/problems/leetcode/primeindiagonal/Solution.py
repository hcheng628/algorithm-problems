class Solution:
    def diagonalPrime(self, nums: List[List[int]]) -> int:
        ret = 0
        l = len(nums)
        left, right = 0, l - 1

        for i in range(l):
            if nums[i][left] > ret and self.isP(nums[i][left]):
                ret = nums[i][left]
            if nums[i][right] > ret and self.isP(nums[i][right]):
                ret = nums[i][right]

            left += 1
            right -= 1


        return ret


    def isP(self, n):
        if n is None or n < 2:
            return False

        for i in range(2, int(sqrt(n)) + 1):
            if n % i == 0:
                return False

        return True
