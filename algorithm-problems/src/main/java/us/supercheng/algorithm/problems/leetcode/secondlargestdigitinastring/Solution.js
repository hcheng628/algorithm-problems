/**
 * @param {string} s
 * @return {number}
 */
var secondHighest = function(s) {
    var ret = [-1, -1],
        i,
        len = s.length,
        num;

    for (i=0; i<len; i+=1) {
        num = s.charAt(i);
        if (num >= '0' && num <= '9') {
            num = parseInt(num);

            if (ret[1] == -1)
                ret[1] = num;
            else {
                if (num > ret[1]) {
                    ret[0] = ret[1];
                    ret[1] = num;
                } else if (num < ret[1] && num > ret[0])
                    ret[0] = num;
            }
        }
    }

    return ret[0];
};
