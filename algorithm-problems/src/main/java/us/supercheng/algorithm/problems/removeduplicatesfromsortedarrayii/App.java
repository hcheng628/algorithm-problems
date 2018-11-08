package us.supercheng.algorithm.problems.removeduplicatesfromsortedarrayii;

public class App {

    public static void main(String[] args) {
        int [] numsA = {0,0,1,1,1,1,2,3,3};
        int [] numsB = {1,1,1,2,2,3};
        int [] numsC = {};
        int [] numsD = {1,1,1};
        int [] numsE = {1,2,2,2};
        int [] numsF = {1,1,1,1};


        App app = new App();

        app.printArr("Before A: ", numsA);
        int res = app.removeDuplicates(numsA);
        app.printArr("After A: ", numsA);
        System.out.println(res);

        app.printArr("Before B: ", numsB);
        res = app.removeDuplicates(numsB);
        app.printArr("After B: ", numsB);
        System.out.println(res);

        app.printArr("Before C: ", numsC);
        res = app.removeDuplicates(numsC);
        app.printArr("After C: ", numsC);
        System.out.println(res);


        app.printArr("Before D: ", numsD);
        res = app.removeDuplicates(numsD);
        app.printArr("After D: ", numsD);
        System.out.println(res);

        app.printArr("Before E: ", numsE);
        res = app.removeDuplicates(numsE);
        app.printArr("After E: ", numsE);
        System.out.println(res);

        app.printArr("Before F: ", numsF);
        res = app.removeDuplicates(numsF);
        app.printArr("After F: ", numsF);
        System.out.println(res);

    }

    public int removeDuplicates(int[] A) {
        int ret = 0;
        for(int i=0;i<A.length-ret;i++)
            if(i >0 && i<A.length-ret-1)
               if(A[i] == A[i-1] && A[i] == A[i+1]){
                   this.shiftLeft(A, i--);
                   ret++;
               }
        return A.length - ret;
    }

    private void shiftLeft(int [] A, int begin) {
        for(int i=begin;i<A.length-1;i++)
            if(A[i] != A[i+1]) {
                int temp = A[i];
                A[i] = A[i+1];
                A[i+1] = temp;
            }
    }

    private void printArr(String s, int [] A) {
        System.out.println(s);
        for(int each : A)
            System.out.print(each + ", ");
        System.out.println();
    }
}
