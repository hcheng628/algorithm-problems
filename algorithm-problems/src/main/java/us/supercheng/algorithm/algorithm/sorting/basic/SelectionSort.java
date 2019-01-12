package us.supercheng.algorithm.algorithm.sorting.basic;

import us.supercheng.algorithm.algorithm.sorting.common.SortTestHelper;
import us.supercheng.algorithm.common.entity.Student;
import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class SelectionSort {

    private SelectionSort() {}

    public static void sort(Comparable [] arr) {
        for(int i=0;i<arr.length;i++) {
            int index = i;
            for(int j=i+1;j<arr.length;j++)
                if(arr[j].compareTo(arr[index]) < 0)
                    index = j;
            ArrayHelper.swap(arr, i, index);
        }
    }

    public static void main(String[] args) throws Exception{
        Integer[] arr = SortTestHelper.generateRandomArray(2000, 0, 100000);
        SortTestHelper.doTestSort(new SelectionSort().getClass().getName(), arr);

        Student[] students = new Student[4];
        students[0] = new Student("D",90);
        students[1] = new Student("C",100);
        students[2] = new Student("B",95);
        students[3] = new Student("A",95);

        PrintHelper.echoLn("Before Sort: ");
        ArrayHelper.echo(students);
        SortTestHelper.doTestSort(new SelectionSort().getClass().getName(), students);
        PrintHelper.echoLn("After Sort: ");
        ArrayHelper.echo(students);
    }
}