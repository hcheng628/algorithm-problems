class Solution(object):
    def largestInteger(self, num):
        """
        :type num: int
        :rtype: int
        """
        ret = 0
        count = [0] * 10
        base = 1

        n = num
        while n != 0:
            count[n % 10] += 1
            n /= 10

        while num != 0:
            curr = num % 10
            for i in range(10):
                if count[i] > 0 and (i + curr) & 1 == 0:
                    count[i] -= 1
                    ret += base * i
                    base *= 10
                    break
            num /= 10

        return ret
