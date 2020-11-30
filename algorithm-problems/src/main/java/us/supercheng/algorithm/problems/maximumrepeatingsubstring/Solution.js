/**
 * @param {string} sequence
 * @param {string} word
 * @return {number}
 */
var maxRepeating = function(sequence, word) {
    var i,
        len_i,
        len_j,
        idx,
        ret = 0;

    for (i=0, len_i=sequence.length, len_j=word.length; i<len_i; i+=1) {
        if (parseInt((len_i - i) / len_j) <= ret)
            break;

        idx = 0;
        while (idx + i < len_i && sequence[idx + i] == word[idx % len_j])
            idx +=1;
        ret = Math.max(parseInt(idx / len_j) ,ret);
    }

    return ret;
};