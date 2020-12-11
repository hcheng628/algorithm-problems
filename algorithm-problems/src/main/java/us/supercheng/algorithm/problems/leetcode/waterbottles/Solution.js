/**
 * @param {number} numBottles
 * @param {number} numExchange
 * @return {number}
 */
var numWaterBottles = function(numBottles, numExchange) {
    var ret = numBottles,
        left;

    for (; numBottles >= numExchange; ret += left) {
        left = parseInt(numBottles / numExchange);
        numBottles = left + numBottles % numExchange;
    }

    return ret;
};