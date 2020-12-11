package us.supercheng.algorithm.problems.leetcode.binarysearch;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        int key = 6;
        System.out.println(app.binarySearch(arr, key));
    }

    public int binarySearch(int[] arr, int key) {
        int begin, end,current;
        begin = 0;
        end = arr.length - 1;
        current = (end - begin) / 2;

        while(begin != end) {
            System.out.println("Begin: " + begin + "[" + arr[begin] + "] End: " + end + "[" + arr[end] + "] Current: " + current + "[" + arr[current] + "]");
            if(arr[current] == key) {
                return current;
            } else if (key > arr[current]) {
                System.out.println("Key is bigger");
                begin = current + 1;
            } else {
                System.out.println("Key is smaller");
                end = current;
            }
            current = (end - begin) / 2 + begin;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if(nums == null)
            return -1;

        if(nums.length==1) {
            if(target==nums[0])
                return 0;
            return -1;
        }

        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid-1 ;
            else
                left = mid + 1;
        }
        return -1;
    }
}