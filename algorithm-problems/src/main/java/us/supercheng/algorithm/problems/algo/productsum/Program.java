package us.supercheng.algorithm.problems.algo.productsum;

import java.util.*;

public class Program {

    public static int productSum_Solution1(List<Object> array) {
        return productSum_Solution1(array, 1);
    }

    private static int productSum_Solution1(List<Object> array, int level) {
        int ret = 0;

        for (Object o : array)
            ret += o instanceof ArrayList ? productSum_Solution1((List<Object>) o, level + 1) : (int) o;

        return ret * level;
    }

    public static int productSum_Solution2(List<Object> array) {
        int ret = 0;
        Queue<Object> q = new LinkedList<>();
        for (Object a : array)
            q.offer(a);

        for (int level = 1, base = 1; !q.isEmpty(); base *= (++level))
            for (int i=q.size(); i>0; i--) {
                Object o = q.poll();
                if (o instanceof ArrayList) {
                    @SuppressWarnings("unchecked")
                    List<Object> list = (List<Object>) o;
                    for (Object l : list)
                        q.offer(l);
                } else
                    ret += ((int) o) * base;
            }

        return ret;
    }

}