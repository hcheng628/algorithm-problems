/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var sumBase = function(n, k) {
    var ret = 0;

    for (; n != 0; n = Math.floor(n / k))
        ret += n % k;

    return ret;
};