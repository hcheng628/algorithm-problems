class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        ret = []
        i, j = 0, 0
        len1, len2 = len(nums1), len(nums2)

        while i < len1 or j < len2:
            if i < len1 and j < len2:
                if nums1[i][0] == nums2[j][0]:
                    ret.append([nums1[i][0], nums1[i][1] + nums2[j][1]])
                    i += 1
                    j += 1
                elif nums1[i][0] < nums2[j][0]:
                    ret.append([nums1[i][0], nums1[i][1]])
                    i += 1
                else:
                    ret.append([nums2[j][0], nums2[j][1]])
                    j += 1
            elif i < len1:
                ret.append([nums1[i][0], nums1[i][1]])
                i += 1
            else:
                ret.append([nums2[j][0], nums2[j][1]])
                j += 1

        return ret
