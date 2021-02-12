/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfUnique = function(nums) {
    var map = {},
        i,
        ret = 0;

    nums.forEach(function(n) {
        map[n] = map[n] ? map[n] + 1 : 1;
    });

    for (i=1; i<101; i+=1)
        if (map[i] && map[i] == 1)
            ret += i;
    return ret;
};