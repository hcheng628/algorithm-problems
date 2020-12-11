class Solution:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        self.idx1 = [0, 0]
        self.idx2 = [0, 0]

        while True:
            c1 = self.getChar(word1, False)
            c2 = self.getChar(word2, True)

            if c1 != c2:
                return False
            elif c1 is None and c2 is None:
                break

        return True


    def getChar(self, arr: List[str], is_word2: bool) -> str:
        ret = None
        idx_cell = self.idx1[0]
        idx = self.idx1[1]
        L = len(arr)

        if is_word2:
            idx_cell = self.idx2[0]
            idx = self.idx2[1]

        if idx_cell < L:
            if idx >= len(arr[idx_cell]):
                idx = 0
                idx_cell +=1

            if idx_cell < L:
                ret = arr[idx_cell][idx]
                idx += 1


        if is_word2:
            self.idx2[0] = idx_cell
            self.idx2[1] = idx
        else:
            self.idx1[0] = idx_cell
            self.idx1[1] = idx

        return ret
