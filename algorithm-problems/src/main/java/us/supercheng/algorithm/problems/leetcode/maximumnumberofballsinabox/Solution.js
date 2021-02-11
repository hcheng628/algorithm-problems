/**
 * @param {number} lowLimit
 * @param {number} highLimit
 * @return {number}
 */
var countBalls = function(lowLimit, highLimit) {
        var m = {},
            i,
            len,
            idx,
            ret = 0;

        for (i=0, len=highLimit - lowLimit + 1; i<len; i+=1) {
            idx = get_idx(i + lowLimit);
            if (m[idx])
                m[idx] +=1;
            else
                m[idx] = 1;
            ret = Math.max(m[idx], ret);
        }

        return ret;
    },
    get_idx = function(num) {
        var ret = 0;
        for (; num != 0; num = parseInt(num / 10))
            ret += num % 10;
        return ret;
    };
