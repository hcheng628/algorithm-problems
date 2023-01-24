class Solution(object):
    def twoOutOfThreeMap(self, nums1, nums2, nums3):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type nums3: List[int]
        :rtype: List[int]
        """
        counts = [[0] * 101 for i in range(3)]
        ret = []

        for n in nums1:
            counts[0][n] = 1
        for n in nums2:
            counts[1][n] = 1
        for n in nums3:
            counts[2][n] = 1

        for num in range(1, 101):
            if counts[0][num] + counts[1][num] + counts[2][num] > 1:
                ret.append(num)

        return ret

    def twoOutOfThree(self, nums1, nums2, nums3):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type nums3: List[int]
        :rtype: List[int]
        """
        s1 = set(nums1)
        s2 = set(nums2)
        s3 = set(nums3)

        ins12 = s1.intersection(s2)
        ins13 = s1.intersection(s3)
        ins23 = s2.intersection(s3)

        return ins12.union(ins13).union(ins23)
