class Solution:
    def average(self, salary: List[int]) -> float:
        length = len(salary)
        minVal = salary[0]
        maxVal = salary[0]
        total = 0.0

        for i in range(length):
            if (salary[i] < minVal):
                minVal = salary[i]
            if (salary[i] > maxVal):
                maxVal = salary[i]
            total += salary[i]

        return (total-minVal-maxVal) / (length-2)