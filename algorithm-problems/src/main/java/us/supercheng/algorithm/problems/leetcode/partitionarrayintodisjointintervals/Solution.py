class Solution:
    def partitionDisjoint(self, A: List[int]) -> int:
        length = len(A)
        arr = [[], []]

        arr[0].append(A[0])
        for i in range (1, length):
            arr[0].append(max(arr[0][i-1], A[i]))

        arr[1].append(A[length-1])
        for i in range (length-2, -1, -1):
            arr[1].insert(0, min(arr[1][0], A[i]))

        for i in range (0, length-1):
            if arr[0][i] <= arr[1][i+1]:
                return i+1

        return -1;

    def partitionDisjointOPT(self, A: List[int]) -> int:
        length = len(A)
        arr = [A[length-1]]
        maxVal = A[0]

        for i in range (length-2, -1, -1):
            arr.insert(0, min(arr[0], A[i]));

        for i in range (length-1):
            maxVal = max(A[i], maxVal)
            if maxVal <= arr[i+1]:
                return i+1

        return -1

    def partitionDisjointGreedy(self, A: List[int]) -> int:
        length = len(A)
        leftMax = A[0]
        currMax = leftMax
        ret = 0

        for i in range(1, length):
            currMax = max(A[i], currMax)
            if leftMax > A[i]:
                leftMax = currMax
                ret = i

        return ret + 1
