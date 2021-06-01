class Solution:
    def checkZeroOnes_Solution1(self, s: str) -> bool:
        zero_max = 0
        one_max = 0
        idx = 0
        size = len(s)

        while idx < size:
            temp = 0

            if s[idx] == '0':
                while idx < size and s[idx] == '0':
                    temp += 1
                    idx += 1

                zero_max = max(temp, zero_max)
            else:
                while idx < size and s[idx] == '1':
                    temp += 1
                    idx += 1

                one_max = max(temp, one_max)

        return one_max > zero_max


    def checkZeroOnes(self, s: str) -> bool:
        zero_max = 0
        one_max = 0

        zeros = s.split('1')
        ones = s.split('0')

        for zero in zeros:
            zero_max = max(len(zero), zero_max)

        for one in ones:
            one_max = max(len(one), one_max)

        return one_max > zero_max
