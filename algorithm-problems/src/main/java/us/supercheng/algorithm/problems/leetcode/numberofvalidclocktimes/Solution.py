class Solution(object):
    def countTime(self, time):
        """
        :type time: str
        :rtype: int
        """
        first = 3 if time[0] == '?' else 1
        second = 0 if time[1] == '?' else 1
        third = 6 if time[3] == '?' else 1
        forth = 10 if time[4] == '?' else 1

        if first == 3 and second != 0 and ord('3') < ord(time[1]):
            first -= 1

        if second == 0:
            if time[0] == '?':
                ret = 0
                for i in range(3):
                    ret += (4 if i == 2 else 10) * third * forth
                return ret
            elif time[0] == '0' or time[0] == '1':
                second = 10
            else:
                second = 4

        return first * second * third * forth
