class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        Solution.mergeSort(nums, 0, len(nums) - 1);
        return nums;

    def mergeSort(nums: List[int], left:int, right:int):
        if left >= right:
            return

        mid = int((left + right) / 2)
        l1 = left
        l2 = mid + 1
        arr = []

        Solution.mergeSort(nums, left, mid)
        Solution.mergeSort(nums, l2, right)

        while l1 <= mid and l2 <= right:
            if nums[l1] < nums[l2]:
                arr.append(nums[l1])
                l1 +=1
            else:
                arr.append(nums[l2])
                l2 +=1

        while l1 <= mid:
            arr.append(nums[l1])
            l1 +=1

        while l2 <= right:
            arr.append(nums[l2])
            l2 +=1

        for i in range(len(arr)):
            nums[left + i] = arr[i]
