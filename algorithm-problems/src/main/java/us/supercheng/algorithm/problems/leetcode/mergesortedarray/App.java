package us.supercheng.algorithm.problems.leetcode.mergesortedarray;

public class App {
    public static void main(String[]  args) {
        App app = new App();
        app.merge(null, 0, null, 0);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertIndex = 0;
        for(int i=0;i<nums2.length;i++) {
            int insertVal = nums2[i];

            for(int j=insertIndex;j<nums1.length;j++) {
                if(insertVal <= nums1[j]) {
                    nums1 = shiftArr(nums1, j);
                    nums1[j] = insertVal;
                    insertIndex++;
                    break;
                }
            }
        }
        for(int i= insertIndex + m; i<nums1.length;i ++) {
            nums1[i] = nums2[insertIndex++];
        }
    }

    public int[] shiftArr(int[] arr, int index) {
        for(int i = arr.length-1;i> index; i--) {
            int shiftVal = arr[i-1];
            arr[i] = shiftVal;
        }
        return arr;
    }
}