class Solution:
    def canFormArray(self, arr: List[int], pieces: List[List[int]]) -> bool:
        m = {}
        idx = 0

        for p in pieces:
            m[p[0]] = p

        while idx < len(arr):
            if arr[idx] not in m:
                return False

            l = m[arr[idx]]
            for p in l:
                if p == arr[idx]:
                    idx += 1
                else:
                    return False

        return True

    def canFormArray1(self, arr: List[int], pieces: List[List[int]]) -> bool:
        l = []
        for a in arr:
            if a in l:
                continue
            for p in pieces:
                if a in p:
                    l += p

        return l == arr

