/**
 * @param {number[]} A
 * @return {number}
 */
var minIncrementForUnique = function(A) {
    var i,
        len,
        ret = 0,
        inc;

    if (A && A.length > 1) {
        A.sort(function(a, b) {
            return a - b;
        });

        for (i=1, len=A.length; i<len; i+=1)
            if (A[i-1] >= A[i]) {
                inc = A[i-1] + 1;
                ret += inc - A[i];
                A[i] = inc;
            }
    }

    return ret;
};