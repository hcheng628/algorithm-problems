/**
 * @param {string} s
 * @return {boolean}
 */
var halvesAreAlike = function(s) {
    var set = new Set(["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]),
        a = 0,
        b = 0,
        i = 0,
        len = s.length,
        half = len / 2;

    for (; i<half; i+=1) {
        if (set.has(s[i]))
            a += 1;
        if (set.has(s[i + half]))
            b += 1;
    }

    return a == b;
};
