class Solution(object):
    def sortPeople(self, names, heights):
        """
        :type names: List[str]
        :type heights: List[int]
        :rtype: List[str]
        """
        m = {}

        for i in range(len(heights)):
            m[heights[i]] = names[i]

        heights.sort(reverse=True)

        return [m[heights[i]] for i in range(len(heights))]
