/**
 * @param {number[][]} accounts
 * @return {number}
 */
var maximumWealth = function(accounts) {
    var ret = 0,
        sum;

    accounts.forEach(function(banks) {
        sum = 0;
        banks.forEach(function(b) {
            sum += b;
        });

        if (sum > ret)
            ret = sum;
    });

    return ret;
};