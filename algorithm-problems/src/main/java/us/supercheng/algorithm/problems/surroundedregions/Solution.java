package us.supercheng.algorithm.problems.surroundedregions;

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length < 2)
            return;

        boolean [][] visited = new boolean [board.length][board[0].length];
        int lastRowIndex = board.length -1,
                lastColIndex = board[0].length-1;

        for(int col=0;col<board[0].length;col++) {
            if(board[0][col] == 'O')
                this.exploreOs(board, visited, 0, col);
            if(board[lastRowIndex][col] == 'O')
                this.exploreOs(board, visited, lastRowIndex, col);
        }

        for(int row=0;row<board.length;row++) {
            if(board[row][0] == 'O')
                this.exploreOs(board, visited, row, 0);
            if(board[row][lastColIndex] == 'O')
                this.exploreOs(board, visited, row, lastColIndex);
        }

        for(int row=0;row<board.length;row++)
            for(int col=0;col<board[row].length;col++)
                if(board[row][col] == 'O' && !visited[row][col])
                    board[row][col] = 'X';
    }

    public void exploreOs(char[][] board, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row > board.length-1 || col > board[0].length-1 || visited[row][col])
            return;

        visited [row][col] = true;
        if(board[row][col] == 'O') {
            this.exploreOs(board, visited, row-1, col);
            this.exploreOs(board, visited, row+1, col);
            this.exploreOs(board, visited, row, col-1);
            this.exploreOs(board, visited, row, col+1);
        }
    }
}