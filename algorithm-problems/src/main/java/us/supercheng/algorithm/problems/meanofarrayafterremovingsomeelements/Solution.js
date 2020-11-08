/**
 * @param {number[]} arr
 * @return {number}
 */
var trimMean = function(arr) {
    var i,
        end,
        len = arr.length,
        idx = parseInt(len * .05),
        sum = 0;

    arr.sort(function(a, b) {
        return a - b;
    });

    for (i=idx, end=len-idx; i<end; i+=1)
        sum += arr[i];

    return sum / (len - idx - idx);
};