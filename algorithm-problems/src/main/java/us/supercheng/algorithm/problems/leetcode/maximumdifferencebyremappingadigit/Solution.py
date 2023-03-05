class Solution(object):
    def minMaxDifference(self, num):
        s = str(num)

        min_val = s.replace(s[0], '0')
        max_val = s
        for c in s:
            if c != '9':
                max_val = max_val.replace(c, '9')
                break

        return int(max_val) - int(min_val)
