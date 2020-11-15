/**
 * @param {number[]} nums
 * @return {number[]}
 */
var frequencySort = function(nums) {
    var map = {},
        i,
        j,
        ret = [],
        curr = 1,
        max = 0;

    nums.forEach(function(n) {
        map[n] = map[n] ? map[n] + 1 : 1;
        max = Math.max(map[n], max);
    });

    for (; curr<=max; curr+=1)
        for (i=100; i>-101; i-=1)
            if (map[i] && map[i] == curr)
                for (j=0; j<curr; j+=1)
                    ret.push(i);

    return ret;
};