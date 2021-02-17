/**
 * @param {string} s
 * @return {number}
 */
var minOperations = function(s) {
    var count = 0,
        i,
        len,
        l = s.split('');

    for (i=1, len=l.length; i<len; i+=1)
        if (l[i - 1] == l[i]) {
            l[i] = l[i - 1] == '0' ? '1' : '0';
            count += 1;
        }


    return Math.min(count, len - count);
};