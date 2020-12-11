/**
 * @param {number[]} pushed
 * @param {number[]} popped
 * @return {boolean}
 */
var validateStackSequences = function(pushed, popped) {
    var i,
        idx = 0,
        len = pushed.length,
        p,
        stack = [],
        set = new Set();

    for (i=0; i<len; i+=1) {
        p = pushed[i];
        stack.push(p);
        set.add(p);

        for (; stack.length > 0 && idx < len && stack[stack.length-1] == popped[idx]; idx+=1)
            stack.pop();

        if (idx < len && set.has(popped[idx]))
            return false;
    }

    return true;
};