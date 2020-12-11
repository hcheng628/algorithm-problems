/**
 * @param {string} text
 * @return {string}
 */
var reorderSpaces = function(text) {
    var len = text.length,
        arr = text.split(' '),
        words = [],
        word_count = 0,
        space_count = 0,
        c,
        c_len,
        size = 0,
        space_blk = '',
        ret = [],
        i;

    arr.forEach(function(a) {
        c = a.trim();
        c_len = c.length;
        if (c_len != 0 && c != ' ') {
            words.push(c);
            word_count += c_len;
        }
    });

    space_count = len - word_count;
    size = parseInt(space_count / (words.length - 1));

    for (i=0; i<size;i++)
        space_blk += ' ';

    words.forEach(function(w) {
        ret.push(w);
        if (space_count >= size) {
            ret.push(space_blk);
            space_count -= size;
        }
    });

    for (i=0; i<space_count; i+=1)
        ret.push(' ');

    return ret.join('');
};