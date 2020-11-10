/**
 * @param {number[][]} A
 * @return {number}
 */
var minFallingPathSum = function(A) {
    var dp = [],
        temp,
        colL = A[0].length,
        c,
        rowL = A.length,
        r,
        res,
        ret;

    if (rowL == 1 && colL == 1)
        return A[0][0];

    for (c=0; c<colL; c+=1)
        dp.push(A[0][c]);

    for (r=1; r<rowL; r+=1) {
        temp = [];
        for (c=0; c<colL; c+=1) {
            res = dp[c];
            if (c-1 > -1 && dp[c-1] < res)
                res = dp[c-1];

            if (c+1 < colL && dp[c+1] < res)
                res = dp[c+1];
            temp.push(res + A[r][c]);

            if (r == rowL - 1) {
                if (ret) {
                    if (temp[c] < ret)
                        ret = temp[c];
                } else
                    ret = temp[c];
            }
        }
        dp = temp;
    }

    return ret;
};