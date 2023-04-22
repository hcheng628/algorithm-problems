class Solution:
    def minNumber(self, nums1: List[int], nums2: List[int]) -> int:
        m1 = collections.Counter(nums1)
        m2 = collections.Counter(nums2)

        for i in range(1, 10):
            if i in m1 and i in m2:
                return i

        min1 = min(nums1)
        min2 = min(nums2)
        return  min(min2 * 10 + min1, min1 * 10 + min2)
