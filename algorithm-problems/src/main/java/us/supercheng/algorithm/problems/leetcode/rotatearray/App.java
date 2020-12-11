package us.supercheng.algorithm.problems.leetcode.rotatearray;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int [] arr = {1,2,3,4,5,6,7};
        app.rotate(arr, 3);
        for(int i=0;i<arr.length;i++) {
            System.out.print(i < arr.length -1 ? arr[i] + ",": arr[i]);
        }
        System.out.println();
        app.rotate2(arr, 3);
        for(int i=0;i<arr.length;i++) {
            System.out.print(i < arr.length -1 ? arr[i] + ",": arr[i]);
        }
    }

    public void rotate(int[] nums, int k) {
        if(nums.length < 2 || k < 1) {
            return;
        }
        k = k % nums.length;
        for(int i=0;i<k;i++) {
            int lastVal = nums[nums.length-1];
            //System.out.println("LastVal: " + lastVal);
            for(int j=nums.length-2; j>=0;j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = lastVal;
        }
    }

    public void rotate2(int[] nums, int k) {
        int size = nums.length;
        if(size <2 || k < 1) {
            return;
        }
        int [] arr = new int[size];
        k = k % size;
        int counter = 0;
        for(int i=k;i<size;i++) {
            arr[i] = nums[counter++];
        }
        for(int i=0;i<k;i++) {
            arr[i] = nums[counter++];
        }
        for(int i=0;i<size;i++) {
            nums[i] = arr[i];
        }
    }
}