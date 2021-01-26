package us.supercheng.algorithm.problems.algo.boggleboard;

import java.util.*;

public class Program {

    // Time: O(board-weight * board-height + 8^word-len * word-count) Space: O(board-weight * board-height + word-count)
    public static List<String> boggleBoard_Solution1(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        Map<Character, List<String>> dicts = new HashMap<>();

        for (int i=0, len=board.length; i<len; i++)
            for (int j=0, cLen=board[i].length; j<cLen; j++) {
                char c = board[i][j];
                if (!dicts.containsKey(c))
                    dicts.put(c, new ArrayList<>());
                List<String> list = dicts.get(c);
                list.add(i + "," + j);
            }

        for (String w : words) {
            char c = w.charAt(0);
            boolean found = false;
            if (dicts.containsKey(c)) {
                for (String from : dicts.get(c)) {
                    int x = Integer.parseInt(from.split(",")[0]);
                    int y = Integer.parseInt(from.split(",")[1]);
                    boolean ans = dfs(dicts, board, x, y, new HashSet<>(), w, 0);
                    if (ans) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    ret.add(w);
            }
        }

        return ret;
    }

    private static boolean dfs(Map<Character, List<String>> dicts, char[][] board, int x, int y, Set<String> visited, String w, int idx) {
        char c = w.charAt(idx);

        if (c != board[x][y])
            return false;
        else if (idx == w.length() - 1)
            return true;

        visited.add(x + "," + y);
        for (String next : getNexts(board, x, y, visited)) {
            String[] pos = next.split(",");
            boolean ans = dfs(dicts, board, Integer.parseInt(pos[0]), Integer.parseInt(pos[1]), visited, w, idx+1);
            if (ans)
                return true;
        }
        visited.remove(x + "," + y);

        return false;
    }

    private static List<String> getNexts(char[][] board, int x, int y, Set<String> visited) {
        List<String> ret = new ArrayList<>();
        for (int i=-1; i<2; i++)
            for (int j=-1; j<2; j++) {
                if (i == 0 && j == 0)
                    continue;
                int newX = x + i;
                int newY = y + j;

                if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[newX].length) {
                    String pos = newX + "," + newY;
                    if (!visited.contains(pos))
                        ret.add(pos);
                }
            }

        return ret;
    }
}

