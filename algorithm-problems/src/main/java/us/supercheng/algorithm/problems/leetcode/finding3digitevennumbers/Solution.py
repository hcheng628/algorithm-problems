class Solution(object):
    def findEvenNumbers(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        ret = []
        m = collections.Counter(digits)

        for num in range(100, 1000, 2):
            curr_map = {}
            curr = num
            i = 0
            for i in range(3):
                n = curr % 10
                curr_map[n] = 1 if n not in curr_map else curr_map[n] + 1
                curr /= 10

            valid = True
            for each in curr_map:
                if each not in m or m[each] < curr_map[each]:
                    valid = False
                    break

            if valid:
                ret.append(num)

        return ret
