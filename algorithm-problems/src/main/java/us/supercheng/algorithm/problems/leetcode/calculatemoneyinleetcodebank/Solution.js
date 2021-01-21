/**
 * @param {number} n
 * @return {number}
 */
var totalMoney = function(n) {
    var ret = 0,
        base = 1 + 2 + 3 + 4 + 5 + 6 + 7,
        amt = parseInt(n / 7),
        days = n % 7,
        i;

    for (i=0; i<amt; i+=1)
        ret += base + (i * 7);

    if (days != 0)
        amt +=1;

    for (i=0; i<days; i+=1) {
        ret += amt;
        amt +=1;
    }

    return ret;
};