class Solution(object):
    def findDifference(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[List[int]]
        """
        ret = [[], []]
        set1 = [0] * 2001
        set2 = [0] * 2001

        for n in nums1:
            set1[n + 1000] += 1
        for n in nums2:
            set2[n + 1000] += 1

        for i in range(0, 2001):
            if set2[i] == 0 and set1[i] > 0:
                ret[0].append(i - 1000)

        for i in range(0, 2001):
            if set1[i] == 0 and set2[i] > 0:
                ret[1].append(i - 1000)

        return ret
