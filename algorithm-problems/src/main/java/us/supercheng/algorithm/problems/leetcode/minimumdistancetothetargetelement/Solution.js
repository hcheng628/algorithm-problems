/**
 * @param {number[]} nums
 * @param {number} target
 * @param {number} start
 * @return {number}
 */
var getMinDistance = function(nums, target, start) {
    var ret = -1;

    nums.forEach(function(num, i) {
        if (num == target && (ret == -1 || Math.abs(i - start) < ret))
            ret = Math.abs(i - start);
    });

    return ret;
};
