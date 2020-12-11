/**
 * @param {number[][]} mat
 * @return {number}
 */
var numSpecial = function(mat) {
        var R = mat.length,
            C = mat[0].length,
            i,
            j,
            row_set = {},
            col_set = {},
            ret = 0;

        for (i=0; i<R; i+=1)
            if (!row_set[i])
                for (j=0; j<C; j++)
                    if (!col_set[j] && mat[i][j] == 1 && checkR(mat, R, i, j) && checkC(mat, C, i, j)) {
                        ret +=1;
                        row_set[i] = true;
                        col_set[j] = true;
                    }

        return ret;
    },
    checkR = function(mat, R, i, j) {
        var idx = i-1;

        for (; idx>-1; idx-=1)
            if (mat[idx][j] == 1)
                return false;

        for (idx=i+1; idx<R; idx+=1)
            if (mat[idx][j] == 1)
                return false;

        return true;
    },
    checkC = function(mat, C, i, j) {
        var idx = j - 1;
        for (; idx>-1; idx-=1)
            if (mat[i][idx] == 1)
                return false;

        for (idx=j+1; idx<C; idx+=1)
            if (mat[i][idx] == 1)
                return false;

        return true;
    };