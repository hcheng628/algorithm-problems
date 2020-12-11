/**
 * @param {string} S
 * @return {number}
 */
var minAddToMakeValid = function(S) {
    var left = 0,
        right = 0,
        i,
        len = S.length;

    for (i=0; i<len; i+=1)
        if (S[i] == '(')
            left +=1;
        else
        if (left == 0)
            right += 1;
        else
            left -= 1;

    return left + right;
};