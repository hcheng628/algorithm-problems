class Solution:
    def secondHighest(self, s: str) -> int:
        l = []

        for c in s:
            if c.isdigit():
                num = int(c)
                if len(l) == 0:
                    l.append(num)
                elif len(l) == 1:
                    if l[0] > num:
                        l.insert(0, num)
                    elif l[0] < num:
                        l.append(num)
                else:
                    if num > l[1]:
                        l[0] = l[1]
                        l[1] = num
                    elif num > l[0] and num != l[1]:
                        l[0] = num

        return l[0] if len(l) == 2 else - 1;
