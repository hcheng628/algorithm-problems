/**
 * @param {number[]} code
 * @param {number} k
 * @return {number[]}
 */
var decrypt =
    function(code, k) {
        var ret = [],
            i,
            ii,
            j,
            len = code.length,
            count = Math.abs(k),
            sum;

        for (i=0; i<len; i+=1) {
            sum = 0;
            for (j=0, ii=i; k !=0 && j<count; j++) {
                if (k > 0)
                    ii = ii + 1 < len ? ii + 1 : 0;
                else if (k < 0)
                    ii = ii - 1 > -1 ? ii - 1 : len - 1;
                sum += code[ii];
            }
            ret.push(sum);
        }

        return ret;
    };