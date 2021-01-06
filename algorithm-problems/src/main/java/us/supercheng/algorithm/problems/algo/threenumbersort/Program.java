package us.supercheng.algorithm.problems.algo.threenumbersort;

public class Program {

    private void swap(int[] arr, int len, int x, int y) {
        if (x >= len || y >= len || x < 0 || y < 0 || x == y)
            return;
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public int[] threeNumberSort_Solution1(int[] array, int[] order) {
        int first = order[0];
        int last = order[2];

        int idx = 0;
        int len = array.length;

        for (int i=0; i<len; i++)
            if (array[i] == first)
                this.swap(array, len, i, idx++);

        for (int i=len - 1; i>-1; i--)
            if (array[i] == last)
                this.swap(array, len, i, idx--);

        return array;
    }

    public int[] threeNumberSort_Solution2(int[] array, int[] order) {
        int[] map = new int[]{0, 0, 0};
        for (int a : array)
            if (a == order[0])
                map[0]++;
            else if (a == order[1])
                map[1]++;
            else
                map[2]++;

        int idx = 0;
        int len = array.length;

        for (; idx<len && map[0] > 0; idx++) {
            array[idx] = order[0];
            map[0]--;
        }

        for (; idx<len && map[1] > 0; idx++) {
            array[idx] = order[1];
            map[1]--;
        }

        for (; idx<len && map[2] > 0; idx++) {
            array[idx] = order[2];
            map[2]--;
        }

        return array;
    }

    public int[] threeNumberSort_Solution3(int[] array, int[] order) {
        int len = array.length;

        int firstIdx = 0;
        int secondIdx = 0;
        int lastIdx = len - 1;

        int first = order[0];
        int second = order[1];

        while (secondIdx <= lastIdx) {
            int curr = array[secondIdx];
            if (curr == first)
                this.swap(array, len, firstIdx++, secondIdx++);
            else if (curr == second)
                secondIdx++;
            else
                this.swap(array, len, secondIdx, lastIdx--);
        }

        return array;
    }
}
