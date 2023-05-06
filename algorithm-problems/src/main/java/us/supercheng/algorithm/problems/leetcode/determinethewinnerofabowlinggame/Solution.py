class Solution:
    def isWinner(self, player1: List[int], player2: List[int]) -> int:
        p1 = self.score(player1)
        p2 = self.score(player2)
        return 0 if p1 == p2 else 1 if p1 > p2 else 2






    def score(self, arr: List[int]) -> int:
        ret = 0

        for i in range(len(arr)):
            ret += arr[i] * 2 if (i > 0 and arr[i - 1] == 10) or (i > 1 and arr[i - 2] == 10) else arr[i]

        return ret
