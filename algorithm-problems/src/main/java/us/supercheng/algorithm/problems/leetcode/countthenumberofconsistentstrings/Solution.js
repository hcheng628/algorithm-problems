/**
 * @param {string} allowed
 * @param {string[]} words
 * @return {number}
 */
var countConsistentStrings = function(allowed, words) {
    var m = new Set(),
        ret = 0,
        i,
        len,
        is_good;

    for (i=0, len=allowed.length; i<len; i+=1)
        m.add(allowed[i]);

    words.forEach(function(w) {
        is_good = true;

        for (i=0, len=w.length; is_good && i<len; i++)
            if (!m.has(w[i]))
                is_good = false;

        if (is_good)
            ret += 1;
    });

    return ret;
};