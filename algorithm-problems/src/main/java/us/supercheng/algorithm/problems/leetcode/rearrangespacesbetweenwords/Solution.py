class Solution:
    def reorderSpaces(self, text: str) -> str:
        arr = text.split(' ')
        words = []
        ret = []
        wordTotalLen = 0

        for a in arr:
            if a != '':
                words.append(a)
                wordTotalLen += len(a)

        spaceCount = len(text) - wordTotalLen
        size = 1
        if len(words) > 1:
            size = spaceCount // (len(words) - 1)

        spaceBlk = ''
        for i in range(size):
            spaceBlk += ' '

        for w in words:
            ret.append(w)
            if spaceCount >= size:
                ret.append(spaceBlk)
                spaceCount -= size

        for i in range(spaceCount):
            ret.append(' ')

        return ''.join(ret)
