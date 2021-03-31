/**
 * @param {string} word
 * @return {number}
 */
var numDifferentIntegers = function(word) {
    var l = [],
        c,
        i,
        len,
        set = new Set();

    for (i=0, len=word.length; i<len; i+=1) {
        c = word[i];
        l.push(c >= '0' && c <= '9' ? c : ' ');
    }

    l.join('').split(' ').forEach(function(token) {
        if (token.length > 0)
            set.add(parseInt(token));
    });

    return set.size;
};