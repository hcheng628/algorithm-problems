/**
 * @param {string} s
 * @return {number}
 */
var maxLengthBetweenEqualCharacters = function(s) {
    var i,
        c,
        len = s.length,
        map = {},
        ret = -1;

    for (i=0;i<len;i+=1) {
        c = s.charAt(i);
        if (map[c])
            map[c].push(i);
        else
            map[c] = [i];
    }

    for (i in map) {
        len = map[i].length;
        if (len > 1 && map[i][len-1] - map[i][0] - 1 > ret)
            ret = map[i][len-1] - map[i][0] - 1;
    }

    return ret;
};