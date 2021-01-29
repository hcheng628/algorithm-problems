/**
 * @param {number[]} gain
 * @return {number}
 */
var largestAltitude = function(gain) {
    var ret = 0,
        curr = 0;

    gain.forEach(function(g) {
        curr += g;
        ret = Math.max(curr, ret);
    });

    return ret;
};