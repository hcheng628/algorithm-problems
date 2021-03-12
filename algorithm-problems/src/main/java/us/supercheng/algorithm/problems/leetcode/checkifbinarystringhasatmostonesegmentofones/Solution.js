/**
 * @param {string} s
 * @return {boolean}
 */
var checkOnesSegment = function(s) {
    var i,
        len,
        list = [];

    for (i=0, len=s.length; i<len; i+=1)
        if (s[i] == '1') {
            if (list.length != 0 && list[list.length - 1] + 1 != i)
                return false;
            list.push(i);
        }

    return true;
};