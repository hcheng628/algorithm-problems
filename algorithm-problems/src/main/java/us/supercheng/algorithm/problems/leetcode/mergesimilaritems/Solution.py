class Solution(object):
    def mergeSimilarItems(self, items1, items2):
        """
        :type items1: List[List[int]]
        :type items2: List[List[int]]
        :rtype: List[List[int]]
        """
        ret = []
        count = [0] * 1001
        for item in items1 + items2:
            count[item[0]] += item[1]

        for i in range(1, 1001):
            if count[i] != 0:
                ret.append([i, count[i]])

        return ret
