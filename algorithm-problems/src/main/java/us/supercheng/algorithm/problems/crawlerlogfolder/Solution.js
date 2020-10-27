/**
 * @param {string[]} logs
 * @return {number}
 */
var minOperations = function(logs) {
    var level = 0;

    logs.forEach(function(l){
        if (l == './')
            return;
        else if (l == '../') {
            if (level > 0)
                level -= 1;
        } else
            level += 1;
    });

    return level;
};