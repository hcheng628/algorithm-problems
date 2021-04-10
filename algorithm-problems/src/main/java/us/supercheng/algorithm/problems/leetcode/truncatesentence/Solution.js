/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var truncateSentence = function(s, k) {
    var arr = s.split(' '),
        l = [],
        i = 0;

    for (i=0; i<k; i+=1)
        l.push(arr[i]);

    return l.join(' ');
};