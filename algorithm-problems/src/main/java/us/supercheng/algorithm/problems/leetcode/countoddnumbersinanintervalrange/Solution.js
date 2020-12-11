/**
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var countOdds = function(low, high) {
    return low % 2 != 0 && high % 2 != 0 ? parseInt((high - low + 1) / 2) + 1 : parseInt((high - low + 1) / 2);
};