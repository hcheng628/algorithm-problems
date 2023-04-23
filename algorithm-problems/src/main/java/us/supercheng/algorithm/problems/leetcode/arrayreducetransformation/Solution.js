/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    if (!nums || nums.length < 1)
        return init;

    nums.forEach(n => {
        init = fn(init, n);
    });

    return init;
};
