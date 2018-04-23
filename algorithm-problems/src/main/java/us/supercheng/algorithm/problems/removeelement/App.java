package us.supercheng.algorithm.problems.removeelement;

public class App {


    public static void main(String[]  args) {
        App app = new App();
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int counter = app.removeElement(arr, 4);
        for(int i=0;i<counter;i++) {
            System.out.print(arr[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        int removeCount = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != val) {
                nums[removeCount++] = nums[i];
            }
        }
        return removeCount;
    }
}