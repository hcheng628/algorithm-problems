/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
    var i,
        L,
        stack = 0,
        ret = 0,
        c;

    for (i=0, L=s.length; i<L; i+=1) {
        c = s.charAt(i);
        if (c == '(') {
            stack += 1;
            ret = Math.max(stack, ret);
        } else if (c == ')')
            stack -= 1;
    }

    return ret;
};