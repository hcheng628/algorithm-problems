/**
 * @param {string} s
 * @return {string}
 */
var replaceDigits = function(s) {
    var arr = s.split(''),
        i,
        len = s.length;

    for (i=1; i<len; i+=2)
        arr[i] = String.fromCharCode(arr[i].charCodeAt(0) - "0".charCodeAt(0) + arr[i - 1].charCodeAt(0));

    return arr.join('');
};