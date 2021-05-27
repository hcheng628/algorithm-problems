/**
 * @param {number[][]} logs
 * @return {number}
 */
var maximumPopulation = function(logs) {
    var bucket = {},
        max = 0,
        ret = 0,
        i,
        len;

    logs.forEach(function(log) {
        for (i=log[0], len=log[1]; i<len; i+=1)
            bucket[i] = bucket[i] ? bucket[i] + 1 : 1;
    });

    for (i=1950; i<2051; i+=1)
        if (bucket[i] && bucket[i] > max) {
            max = bucket[i];
            ret = i;
        }


    return ret;
};
