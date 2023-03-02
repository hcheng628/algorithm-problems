class Solution:
    def categorizeBox(self, length: int, width: int, height: int, mass: int) -> str:
        heavy = mass >= 100
        bulky = max(length, width, height) >= 10**4 or length * width * height >= 10**9

        if heavy and bulky:
            return "Both"
        elif heavy:
            return "Heavy"
        return "Bulky" if bulky else "Neither"
