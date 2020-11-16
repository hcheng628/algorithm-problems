/**
 * @param {number} N
 * @return {number[]}
 */
var beautifulArray = function(N) {
    var arr = [1],
        ret = [],
        l,
        r;

    while (arr.length < N) {
        l = [];
        r = [];

        arr.forEach(function(e) {
            l.push(e * 2);
            r.push(e * 2 - 1);
        });

        arr = l.concat(r);
    }

    arr.forEach(function(e) {
        if (e <= N)
            ret.push(e);
    });

    return ret;
};