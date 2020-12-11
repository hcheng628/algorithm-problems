/**
 * @param {number[]} A
 * @return {number}
 */
var maxSubarraySumCircular = function(A) {
    var curr_max,
        max,
        curr_min,
        min,
        total,
        curr,
        i,
        len;

    if (!A || A.length == 0)
        return 0;

    curr_max = max = curr_min = min = total = A[0];
    for (i=1, len=A.length; i<len; i+=1) {
        curr = A[i];
        curr_max = Math.max(curr_max + curr, curr);
        max = Math.max(curr_max, max);

        curr_min = Math.min(curr_min + curr, curr);
        min = Math.min(curr_min, min);

        total += curr;
    }

    return total == min ? max : Math.max(max, total - min);
};