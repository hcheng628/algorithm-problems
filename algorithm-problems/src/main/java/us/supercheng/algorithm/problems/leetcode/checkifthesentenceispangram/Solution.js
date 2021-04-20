/**
 * @param {string} sentence
 * @return {boolean}
 */
var checkIfPangram = function(sentence) {
    var set = new Set(),
        i,
        len = sentence.length;

    for (i=0; i<len; i+=1)
        set.add(sentence[i]);

    return set.size == 26;
};