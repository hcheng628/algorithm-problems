/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {

    return function(x) {
        var ret, i;

        if (!functions || functions.length < 1)
            return x;

        for (i = functions.length - 1, ret = x; i > -1; i -= 1)
            ret = functions[i](ret);

        return ret;
    }

};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
