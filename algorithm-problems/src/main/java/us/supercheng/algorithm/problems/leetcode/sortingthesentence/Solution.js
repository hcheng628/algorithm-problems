/**
 * @param {string} s
 * @return {string}
 */
var sortSentence = function(s) {
    var arr = s.split(' '),
        words = new Array(arr.length),
        last_idx;

    arr.forEach(function(a) {
        last_idx = a.length - 1;
        words[parseInt(a.charAt(last_idx)) - 1] = a.substring(0, last_idx);
    });

    return words.join(' ');
};
