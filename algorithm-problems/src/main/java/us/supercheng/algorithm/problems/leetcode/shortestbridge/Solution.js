/**
 * @param {number[][]} A
 * @return {number}
 */
var shortestBridge = function (A) {
        var q = [],
            R = A.length,
            C = A[0].length,
            i,
            j,
            size,
            curr,
            curr_x,
            curr_y,
            ret = 0,
            finding = true;

        for (i = 0; finding && i < R; i += 1)
            for (j = 0; finding && j < C; j += 1)
                if (A[i][j] == 1) {
                    findIsland(A, q, R, C, i, j);
                    finding = false;
                }

        for (; q.length != 0; ret += 1) {
            size = q.length;
            for (i = 0; i < size; i += 1) {
                curr = q.shift();
                curr_x = parseInt(curr / 100);
                curr_y = curr % 100;

                if (curr_x - 1 > -1) {
                    if (A[curr_x - 1][curr_y] == 1)
                        return ret;
                    else if (A[curr_x - 1][curr_y] == 0) {
                        A[curr_x - 1][curr_y] = 2;
                        q.push(normPos(curr_x - 1, curr_y));
                    }
                }

                if (curr_x + 1 < R) {
                    if (A[curr_x + 1][curr_y] == 1)
                        return ret;
                    else if (A[curr_x + 1][curr_y] == 0) {
                        A[curr_x + 1][curr_y] = 2;
                        q.push(normPos(curr_x + 1, curr_y))
                    }
                }

                if (curr_y - 1 > -1) {
                    if (A[curr_x][curr_y - 1] == 1)
                        return ret;
                    else if (A[curr_x][curr_y - 1] == 0) {
                        A[curr_x][curr_y - 1] = 2;
                        q.push(normPos(curr_x, curr_y - 1));
                    }
                }

                if (curr_y + 1 < C) {
                    if (A[curr_x][curr_y + 1] == 1)
                        return ret;
                    else if (A[curr_x][curr_y + 1] == 0) {
                        A[curr_x][curr_y + 1] = 2;
                        q.push(normPos(curr_x, curr_y + 1));
                    }
                }
            }
        }

        return ret;
    },
    findIsland = function (A, q, R, C, x, y) {
        if (x < 0 || y < 0 || x >= R || y >= C || A[x][y] != 1)
            return;

        A[x][y] = 2;
        q.push(normPos(x, y));
        findIsland(A, q, R, C, x + 1, y);
        findIsland(A, q, R, C, x - 1, y);
        findIsland(A, q, R, C, x, y + 1);
        findIsland(A, q, R, C, x, y - 1);
    },
    normPos = function (x, y) {
        return x * 100 + y;
    };