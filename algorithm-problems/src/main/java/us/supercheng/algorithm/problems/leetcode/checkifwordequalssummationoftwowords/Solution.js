/**
 * @param {string} firstWord
 * @param {string} secondWord
 * @param {string} targetWord
 * @return {boolean}
 */
var isSumEqual = function(firstWord, secondWord, targetWord) {
    return parseInt(getNum(firstWord)) + parseInt(getNum(secondWord)) == parseInt(getNum(targetWord));
};

var getNum = function(s) {
    var i,
        len = s.length,
        list = [],
        base_code = 'a'.charCodeAt(0);

    for (i=0; i<len; i +=1)
        list.push((s.charAt(i).charCodeAt(0) - base_code));

    return list.join('');
};