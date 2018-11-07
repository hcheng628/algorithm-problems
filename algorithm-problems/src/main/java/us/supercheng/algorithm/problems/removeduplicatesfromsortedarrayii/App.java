package us.supercheng.algorithm.problems.removeduplicatesfromsortedarrayii;

public class App {

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,1,2,3,3};
        App app = new App();

        app.printArr("Before: ", nums);

        app.removeDuplicates(nums);
        app.printArr("After: ", nums);

    }

    public int removeDuplicates(int[] A) {
        this.shiftHelper(A, 2, 2);
        return 0;
    }

    private void shiftHelper(int [] A, int begin, int count) {
        for(int i=0;i<count;i++) {
            this.shiftLeft(A,begin+i);
        }
    }

    private void shiftLeft(int [] A, int begin) {
        for(int i=begin;i<A.length-1;i++) {
            if(A[i] != A[i+1]) {
                this.swap(A, i, i+1);
            }
        }
    }

    private void swap(int [] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    private void printArr(String s, int [] A) {
        System.out.println(s);
        for(int each : A)
            System.out.print(each + ", ");
        System.out.println();
    }
}
