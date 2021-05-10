package us.supercheng.algorithm.problems.algo.countinversions;

import java.util.*;

public class Program {

    // Time: O(n^2) Space: O(1)
    public int countInversions_Solution1(int[] array) {
        int ret = 0;

        for (int i=0, len=array.length; i<len; i++)
            for (int j=i+1; j<len; j++)
                if (array[i] > array[j])
                    ret++;

        return ret;
    }

    // Time: O(nlog(n)) Space: O(n)
    public int countInversions(int[] array) {
        List<Integer> arr = new ArrayList<>();
        for (int i=0, len=array.length; i<len; i++)
            arr.add(array[i]);

        return this.mergeSort(arr).count;
    }

    private Info mergeSort(List<Integer> list) {
        int len = list != null ? list.size() : 0;

        if (len < 2) {
            List<Integer> l = new ArrayList<>();
            if (len == 1)
                l.add(list.get(0));
            return new Info(l, 0);
        }

        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        List<Integer> l = new ArrayList<>();

        int mid = len / 2;
        int count = 0;

        for (int i=0; i<mid; i++)
            left.add(list.get(i));

        for (int i=mid; i<len; i++)
            right.add(list.get(i));

        Info leftInfo = this.mergeSort(left);
        Info rightInfo = this.mergeSort(right);
        left = leftInfo.list;
        right = rightInfo.list;

        while (!left.isEmpty() && !right.isEmpty()) {
            int leftVal = left.get(0);
            int rightVal = right.get(0);

            if (rightVal < leftVal) {
                right.remove(0);
                l.add(rightVal);
                count += left.size();
            } else {
                left.remove(0);
                l.add(leftVal);
            }
        }

        while (!left.isEmpty())
            l.add(left.remove(0));

        while (!right.isEmpty())
            l.add(right.remove(0));

        return new Info(l, leftInfo.count + rightInfo.count + count);
    }

    class Info {
        List<Integer> list;
        int count;

        Info (List<Integer> list, int count) {
            this.list = list;
            this.count = count;
        }
    }
}
