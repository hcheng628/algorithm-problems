class Solution:
    def containsPattern(self, arr: List[int], m: int, k: int) -> bool:
        length = len(arr)

        for i in range(length):
            patt = []

            if i+m < length:
                for j in range(m):
                    patt.append(arr[i+j])

                count = 1
                start = i + m
                matchP = True

                while start + m <= length:
                    idxP = 0
                    idxA = start
                    while idxA < length and idxP < m:
                        if patt[idxP] != arr[idxA]:
                            matchP = False
                            break

                        idxP +=1
                        idxA +=1

                    start += m

                    if matchP:
                        count += 1
                        if count == k:
                            return True
                    else:
                        break

        return False