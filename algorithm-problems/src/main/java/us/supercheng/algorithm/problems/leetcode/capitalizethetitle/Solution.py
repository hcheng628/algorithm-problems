class Solution(object):
    def capitalizeTitle(self, title):
        """
        :type title: str
        :rtype: str
        """
        l = []
        for t in title.split():
            t = t.lower()
            l.append(t.capitalize() if len(t) > 2 else t)

        return " ".join(l)
