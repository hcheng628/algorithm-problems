class Solution(object):
    def pivotInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        left, right, left_sum, right_sum = 1, n, 1, n

        while left < right:
            if left_sum == right_sum:
                left += 1
                left_sum += left
                right -= 1
                right_sum += right
            elif left_sum < right_sum:
                left += 1
                left_sum += left
            else:
                right -= 1
                right_sum += right

        return left if left == right and left_sum == right_sum else -1
