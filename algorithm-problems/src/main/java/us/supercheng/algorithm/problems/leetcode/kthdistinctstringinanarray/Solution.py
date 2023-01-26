class Solution(object):
    def kthDistinct(self, arr, k):
        """
        :type arr: List[str]
        :type k: int
        :rtype: str
        """
        unique = set()
        duplicate = set()
        count = 0

        for a in arr:
            if a in unique:
                unique.remove(a)
                duplicate.add(a)
            elif a not in duplicate:
                unique.add(a)

        for a in arr:
            if a in unique:
                count += 1
                if count == k:
                    return a

        return ""

    def kthDistinctOPT(self, arr, k):
        """
        :type arr: List[str]
        :type k: int
        :rtype: str
        """
        count_info = collections.Counter(arr)
        count = 0

        for a in arr:
            if count_info[a] == 1:
                count += 1
                if count == k:
                    return a
        return ""