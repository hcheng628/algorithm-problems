/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
var smallestRangeII = function(A, K) {
    var last_idx=A.length-1,
        idx=1,
        ret;

    A.sort(function(a, b) {
        return a - b;
    });

    for (ret=A[last_idx]-A[0]; idx<=last_idx; idx+=1)
        ret = Math.min(ret, Math.max(A[idx-1]+K, A[last_idx]-K) - Math.min(A[0]+K, A[idx]-K));

    return ret;
};