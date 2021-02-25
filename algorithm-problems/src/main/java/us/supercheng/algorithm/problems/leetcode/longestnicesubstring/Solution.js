/**
 * @param {string} s
 * @return {string}
 */
var longestNiceSubstring = function(s) {
        var i,
            j,
            len,
            curr,
            ret = '';

        for (i=0, len=s.length; i<len; i+=1)
            for (j=i; j<len; j++) {
                curr = s.substring(i, j + 1);
                if (curr.length > ret.length && isNice(curr))
                    ret = curr;
            }

        return ret;
    },
    isNice = function(s) {
        var m,
            i,
            c;

        if (!s || s.length < 2)
            return false;

        m = {};
        for (c of s)
            m[c] = true;

        for (i=0; i<27; i+=1)
            if (m[String.fromCharCode('a'.charCodeAt(0) + i)] != m[String.fromCharCode('A'.charCodeAt(0) + i)])
                return false;

        return true;
    };