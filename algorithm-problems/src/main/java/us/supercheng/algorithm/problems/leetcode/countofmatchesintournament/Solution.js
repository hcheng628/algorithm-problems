/**
 * @param {number} n
 * @return {number}
 */
var numberOfMatches = function(n) {
    var matches,
        next_round;

    if (n < 2)
        return 0;

    matches = parseInt(n / 2);
    next_round = n % 2 == 0 ? matches :  matches + 1;

    return matches + numberOfMatches(next_round);
};