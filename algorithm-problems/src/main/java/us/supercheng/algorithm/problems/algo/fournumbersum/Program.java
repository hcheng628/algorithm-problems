package us.supercheng.algorithm.problems.algo.fournumbersum;

import java.util.*;

public class Program {

    // Time O(n^4) Space O(1)
    public static List<Integer[]> fourNumberSum_Solution1(int[] array, int targetSum) {
        List<Integer[]> ret = new ArrayList<>();

        for (int i=0, len=array.length; i<len; i++)
            for (int j=i+1; j<len;j++)
                for (int k=j+1; k<len; k++)
                    for (int l=k+1; l<len; l++)
                        if (array[i] + array[j] + array[k] + array[l] == targetSum)
                            ret.add(new Integer[]{array[i], array[j], array[k], array[l]});

        return ret;
    }

    // Time O(n^3 * log(n)) Space O(1)
    public static List<Integer[]> fourNumberSum_Solution2(int[] array, int targetSum) {
        Arrays.sort(array); // nlog(n)
        List<Integer []> ret = new ArrayList<>();

        for (int i=0, len = array.length; i<len; i++)
            for (int j=i+1; j<len; j++)
                for (int k=j+1; k<len; k++) {
                    int target = targetSum - (array[i] + array[j] + array[k]);
                    if (target < 0)
                        break;
                    int idx = Arrays.binarySearch(array, k+1, len, target);
                    if (idx > -1)
                        ret.add(new Integer[]{array[i], array[j], array[k], array[idx]});
                }

        return ret;
    }

    // Time O(n^3) Space O(n^2)
    public static List<Integer[]> fourNumberSum_Solution3(int[] array, int targetSum) {
        List<Integer[]> ret = new ArrayList<>();
        Map<Integer, List<Integer[]>> map = new HashMap<>();

        for (int i=0, len=array.length; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                List<Integer[]> set = map.get(targetSum - array[i] - array[j]);
                if (set != null)
                    for (Integer[] row : set)
                        ret.add(new Integer[]{row[0], row[1], array[i], array[j]});
            }

            for (int j=i-1; j>-1; j--) {
                int sum = array[i] + array[j];
                List<Integer[]> list = map.get(sum);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(sum, list);
                }
                list.add(new Integer[]{array[i], array[j]});
            }
        }

        return ret;
    }

}
