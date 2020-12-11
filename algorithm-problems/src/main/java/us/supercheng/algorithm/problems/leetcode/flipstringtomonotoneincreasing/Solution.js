/**
 * @param {string} S
 * @return {number}
 */
var minFlipsMonoIncr = function(S) {
    var dp0 = {},
        dp1 = {},
        len = S.length,
        i,
        left,
        right,
        ones = 0,
        zeros = 0,
        ret = len;

    dp0[0] = S.charAt(0) == '0' ? 1 : 0;
    for (i=1; i<len; i+=1)
        dp0[i] = dp0[i-1] + (S.charAt(i) == '0' ? 1 : 0);

    dp1[len-1] = S.charAt(len-1) == '1' ? 1 : 0;
    for (i=len-2; i>-1; i-=1)
        dp1[i] = dp1[i+1] + (S.charAt(i) == '1' ? 1 : 0);

    for (i=0; i<len; i+=1) {
        if (S.charAt(i) == '0')
            zeros +=1;
        else
            ones +=1;

        left = i + 1;
        right = len - left;

        ret = Math.min(left - dp0[i] + right - dp1[i], ret);
    }

    return Math.min(ret, Math.min(len - zeros, len - ones));
};