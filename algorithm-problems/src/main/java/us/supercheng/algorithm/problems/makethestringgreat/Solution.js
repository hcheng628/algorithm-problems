/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function(s) {
        var idx;

        while (true) {
            idx = check(s);
            if (idx == -1)
                break;
            s = s.substring(0, idx-1) + s.substring(idx+1, s.length);
        }

        return s;
    },

    check = function(s) {
        var prev,
            curr,
            i,
            len;

        if (!s || s.length < 2)
            return -1;

        for (i=1, len=s.length; i<len; i+=1) {
            prev = s[i-1];
            curr = s[i];
            if (prev != curr && prev.toUpperCase() == curr.toUpperCase())
                return i;
        }

        return -1;
    };