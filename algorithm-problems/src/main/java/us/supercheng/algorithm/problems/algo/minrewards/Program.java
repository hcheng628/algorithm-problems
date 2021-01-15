package us.supercheng.algorithm.problems.algo.minrewards;

import java.util.*;

public class Program {

    public static int minRewards_Solution1(int[] scores) {
        int len = scores.length;
        int[] rewards = new int[len];
        Arrays.fill(rewards, 1);

        for (int i=1; i<len; i++) {
            if (scores[i - 1] > scores[i])
                checkBefore(scores, rewards, i);
            else
                rewards[i] = rewards[i - 1] + 1;
        }

        int ret = 0;
        for (int r : rewards)
            ret += r;
        return ret;
    }

    private static void checkBefore(int[] arr, int[] rewards, int idx) {
        for (; idx > 0 && arr[idx - 1] > arr[idx]; idx--)
            rewards[idx - 1] = Math.max(rewards[idx - 1], rewards[idx] + 1);
    }

    public static int minRewards_Solution2(int[] scores) {
        int len = scores.length;
        if (len == 1)
            return len;

        int[] rewards = new int[len];
        Arrays.fill(rewards, 1);

        for (int i=0; i<len; i++)
            if (i == 0) {
                if (scores[i] < scores[i+1])
                    processToPeak(scores, rewards, i);
            } else if (i == len - 1) {
                if (scores[i-1] > scores[i])
                    processToPeak(scores, rewards, i);
            } else
            if (scores[i] < scores[i+1] && scores[i-1] > scores[i]) {
                processToPeak(scores, rewards, i);
            }

        int ret = 0;
        for (int r : rewards)
            ret += r;
        return ret;
    }

    private static void processToPeak(int[] scores, int[] rewards, int idx) {
        for (int left=idx-1; left > -1 && scores[left] > scores[left+1] ;left--)
            rewards[left] = Math.max(rewards[left + 1] + 1, rewards[left]);
        for (int right=idx+1; right < scores.length && scores[right - 1] < scores[right]; right++)
            rewards[right] = Math.max(rewards[right - 1] + 1, rewards[right]);
    }

    public static int minRewards_Solution3(int[] scores) {
        int len = scores.length;
        int[] rewards = new int[len];

        rewards[0] = 1;
        for (int i=1; i<len;i++)
            rewards[i] = scores[i - 1] < scores[i] ? rewards[i - 1] + 1 : 1;

        int ret = rewards[len - 1];
        for (int i=len-2; i>-1; i--) {
            if (scores[i] > scores[i + 1])
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
            ret += rewards[i];
        }

        return ret;
    }

}
