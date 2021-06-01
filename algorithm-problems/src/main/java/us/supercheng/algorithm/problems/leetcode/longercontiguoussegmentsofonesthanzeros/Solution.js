/**
 * @param {string} s
 * @return {boolean}
 */
var checkZeroOnes = function(s) {
    var zero_max = 0,
        one_max = 0,
        zero_list = s.split('1'),
        one_list = s.split('0');

    zero_list.forEach(function(zero) {
        zero_max = Math.max(zero.length, zero_max);
    });

    one_list.forEach(function(one) {
        one_max = Math.max(one.length, one_max);
    });

    return one_max > zero_max;
};