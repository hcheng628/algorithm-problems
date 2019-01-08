package us.supercheng.algorithm.algorithm.sorting.basic;

import us.supercheng.algorithm.common.entity.Student;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class SelectionSort {

    private SelectionSort() {}

    public static void sort(Comparable [] arr) {
        for(int i=0;i<arr.length;i++) {
            int index = i;
            for(int j=i+1;j<arr.length;j++)
                if(arr[j].compareTo(arr[index]) < 0)
                    index = j;
            Comparable temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public static void main(String[] args) throws Exception{
        Integer[] arr = SortTestHelper.generateRandomArray(2000, 0, 100000);
        SortTestHelper.doTestSort("us.supercheng.algorithm.algorithm.sorting.basic.SelectionSort", arr);
        SortTestHelper.printArray(arr);

        Student[] d = new Student[4];
        d[0] = new Student("D",90);
        d[1] = new Student("C",100);
        d[2] = new Student("B",95);
        d[3] = new Student("A",95);
        SelectionSort.sort(d);
        for( int i = 0 ; i < d.length ; i ++ )
            PrintHelper.echoLn(d[i]);
    }
}