class Solution:
    def squareIsWhite(self, coordinates: str) -> bool:
        col = ord(coordinates[0]) - ord('a')
        row = ord(coordinates[1]) - ord('1')
        return not (col % 2 == row % 2)
