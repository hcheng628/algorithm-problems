/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function(word1, word2) {
    var list = [],
        len1 = word1.length,
        len2 = word2.length,
        endIdx = Math.min(len1, len2),
        i;

    for (i=0; i<endIdx; i+=1) {
        list.push(word1[i]);
        list.push(word2[i]);
    }

    for (i=endIdx; i<len1; i+=1)
        list.push(word1[i]);

    for (i=endIdx; i<len2; i+=1)
        list.push(word2[i]);

    return list.join('');
};
