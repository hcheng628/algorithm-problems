/**
 * @param {number[]} encoded
 * @param {number} first
 * @return {number[]}
 */
var decode = function(encoded, first) {
    var ret = [first];

    encoded.forEach(function(num) {
        ret.push(num ^ ret[ret.length - 1]);
    });

    return ret;
};