package us.supercheng.algorithm.problems.removeduplicatesfromsortedarray;

public class App {

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = removeDuplicates(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int count = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i]) {
                nums[++count] = nums[i];
            }
            prev = nums[i];
        }
        return ++count;
    }

    public int removeDuplicates2(int[] nums) {
        int prev = 0;
        for (int i=1;i<nums.length;i++)
            if (nums[prev] != nums[i])
                nums[++prev] = nums[i];
        return prev+1;
    }
}