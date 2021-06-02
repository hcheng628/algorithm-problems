/**
 * @param {string} s
 * @return {number}
 */
var countGoodSubstrings = function(s) {
    var left = 0,
        right = 0,
        ret = 0,
        size,
        len = s.length,
        a,
        b,
        c;

    while (right < len) {
        size = right - left + 1;

        if (size < 3)
            right += 1;
        else if (size == 3) {
            a = s.charAt(left);
            b = s.charAt(left + 1);
            c = s.charAt(right);

            if (a != b && b != c && a != c)
                ret += 1;

            right += 1;
        } else
            left += 1;
    }

    return ret;
};