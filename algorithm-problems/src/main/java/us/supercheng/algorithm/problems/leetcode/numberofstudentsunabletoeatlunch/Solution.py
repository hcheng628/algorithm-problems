class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        bucket = [0, 0]

        for stu in students:
            bucket[stu] += 1

        for sand in sandwiches:
            if (bucket[sand] < 1):
                return bucket[1 - sand]
            bucket[sand] -= 1

        return 0
