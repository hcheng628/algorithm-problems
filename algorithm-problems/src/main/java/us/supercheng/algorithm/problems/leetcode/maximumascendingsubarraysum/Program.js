/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAscendingSum = function(nums) {
    var i,
        len = nums.length,
        ret = nums[0],
        sum;

    for (i=0; i<len - 1; i+=1) {
        sum = nums[i];

        while (i + 1 < len && nums[i] < nums[i + 1]) {
            sum += nums[i + 1];
            i += 1;
        }

        ret = Math.max(sum, ret);
    }

    return ret;
};