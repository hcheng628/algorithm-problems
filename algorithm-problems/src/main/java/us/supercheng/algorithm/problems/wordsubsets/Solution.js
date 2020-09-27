/**
 * @param {string[]} A
 * @param {string[]} B
 * @return {string[]}
 */
var wordSubsets = function(A, B) {
        var ret = [],
            m = {},
            k,
            row,
            is_adding;

        B.forEach(function(s) {
            row = initMap(s);
            for (k in row)
                m[k] = m[k] ? Math.max(row[k], m[k]) : row[k];
        });

        A.forEach(function(s) {
            row = initMap(s);
            is_adding = true;

            for (k in m)
                if (!row[k] || m[k] > row[k]) {
                    is_adding = false;
                    break;
                }

            if (is_adding)
                ret.push(s);
        });

        return ret;
    },

    initMap = function(s) {
        var i = 0,
            len = s.length,
            m = {},
            k;

        for (; i < len; i += 1) {
            k = s.charAt(i);
            m[k] = m[k] ? m[k] + 1 : 1;
        }

        return m;
    };