package us.supercheng.algorithm.problems.wordsearch;

public class App {
    public boolean exist(char[][] board, String word) {
        char [] chars = word.toCharArray();
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++)
                if(board[i][j] == chars[0] && this.helper(board, chars, i, j, 0, new boolean[board.length][board[board.length-1].length]))
                    return true;
        return false;
    }

    private boolean helper(char[][] board, char[] chars, int x, int y, int index, boolean [][] visited) {
        if(x < 0 || y < 0 || x > board.length -1 || y > board[x].length -1 || visited[x][y])
            return false;
        if(index == chars.length -1)
            return true;

        boolean ret = false;
        visited[x][y] = true;
        if(x+1 <= board.length -1 && index+1 <= chars.length -1 && board[x+1][y] == chars[index+1])
            ret = ret || this.helper(board, chars, x+1, y, index+1, visited);
        if(x-1 >= 0 && index+1 <= chars.length -1 && board[x-1][y] == chars[index+1])
            ret = ret || this.helper(board, chars, x-1, y, index+1, visited);
        if(y+1 <= board[x].length-1 && index+1 <= chars.length -1 && board[x][y+1] == chars[index+1])
            ret = ret || this.helper(board, chars, x, y+1, index+1, visited);
        if(y-1 >=0 && index+1 <= chars.length -1 && board[x][y-1] == chars[index+1])
            ret = ret || this.helper(board, chars, x, y-1, index+1, visited);
        visited[x][y] = false;

        return ret;
    }
}