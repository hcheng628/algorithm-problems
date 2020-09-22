/**
 * @param {number[]} A
 * @return {number}
 */
var partitionDisjoint = function(A) {
    var len = A.length,
        arr = [[],[]],
        i;

    arr[0].push(A[0]);
    for (i=1; i<len;i+=1)
        arr[0].push(Math.max(arr[0][i-1], A[i]));

    arr[1].push(A[len-1]);
    for (i=len-2; i>-1; i-=1)
        arr[1].unshift(Math.min(arr[1][0], A[i]));

    for (i=0; i<len-1; i+=1)
        if (arr[0][i] <= arr[1][i+1])
            return i+1;

    return -1;
};

var partitionDisjointOPT = function(A) {
    var len = A.length,
        arr = [],
        curr_max = A[0],
        i;

    arr.push(A[len-1]);
    for (i=len-2; i>-1; i-=1)
        arr.unshift(Math.min(arr[0], A[i]));

    for (i=0; i<len-1; i+=1) {
        curr_max = Math.max(curr_max, A[i]);
        if (curr_max <= arr[i+1])
            return i+1;
    }

    return -1;
};

var partitionDisjointGreedy = function(A) {
    var len = A.length,
        idx = 0,
        i = 0,
        left_max = A[0],
        curr_max = left_max;

    for (; i<len; i+=1) {
        curr_max = Math.max(A[i], curr_max)
        if (A[i] < left_max) {
            left_max = curr_max;
            idx = i;
        }
    }

    return idx+1;
};