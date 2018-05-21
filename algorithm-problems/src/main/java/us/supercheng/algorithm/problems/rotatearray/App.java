package us.supercheng.algorithm.problems.rotatearray;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int [] arr = {1,2,3,4,5,6,7};
        app.rotate(arr, 3);
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
}